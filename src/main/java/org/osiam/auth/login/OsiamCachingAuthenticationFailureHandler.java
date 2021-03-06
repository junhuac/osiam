/*
 * Copyright (C) 2013 tarent AG
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.osiam.auth.login;

import com.google.common.base.Strings;
import org.osiam.auth.exception.LdapAuthenticationProcessException;
import org.osiam.security.helper.LoginDecisionFilter;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OsiamCachingAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final String LAST_USERNAME_KEY = "LAST_USERNAME";
    private static final String LAST_PROVIDER_KEY = "LAST_PROVIDER";
    private static final String ERROR_KEY = "ERROR_KEY";
    private static final String IS_LOCKED = "IS_LOCKED";

    public OsiamCachingAuthenticationFailureHandler(String defaultFailureUrl) {
        super(defaultFailureUrl);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        super.onAuthenticationFailure(request, response, exception);

        if (request.getSession(false) == null && !isAllowSessionCreation()) {
            return;
        }

        request.getSession().setAttribute(
                LAST_USERNAME_KEY, request.getParameter(LoginDecisionFilter.USERNAME_PARAMETER)
        );
        request.getSession().setAttribute(
                LAST_PROVIDER_KEY,
                Strings.isNullOrEmpty(request.getParameter("provider"))
                        ? "internal"
                        : request.getParameter("provider")
        );
        request.getSession().setAttribute(IS_LOCKED, false);
        if (exception instanceof LdapAuthenticationProcessException) {
            request.getSession().setAttribute(ERROR_KEY, "login.ldap.internal.user.exists");
        } else if (exception instanceof LockedException) {
            request.getSession().setAttribute(IS_LOCKED, true);
        }
    }
}
