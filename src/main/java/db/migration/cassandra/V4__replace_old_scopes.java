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

package db.migration.cassandra;

import com.contrastsecurity.cassandra.migration.api.MigrationChecksumProvider;
import com.contrastsecurity.cassandra.migration.api.JavaMigration;

import com.datastax.driver.core.Session;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import java.util.HashMap;
import java.util.Map;

public class V4__replace_old_scopes implements JavaMigration, MigrationChecksumProvider {

    private final Map<String, Long> internalIds = new HashMap<>();
    private Session connection;

    @Override
    public Integer getChecksum() {
        return 1546262391;
    }

    @Override
    public void migrate(Session connection) throws Exception {
        this.connection = connection;
        removeScopesFromClient("example-client", "GET", "POST", "PUT", "PATCH", "DELETE");
        addScopesToClient("example-client", "ADMIN", "ME");
        removeScopesFromClient("addon-self-administration-client", "GET", "POST", "PUT", "PATCH", "DELETE");
        addScopesToClient("addon-self-administration-client", "ADMIN");
        removeScopesFromClient("addon-administration-client", "GET", "POST", "PUT", "PATCH", "DELETE");
        addScopesToClient("addon-administration-client", "ADMIN");
    }

    private void removeScopesFromClient(String clientId, String... scopes) throws Exception {
        long internalId = toInternalId(clientId);
        if (internalId < 0) {
            return;
        }
        for (String scope : scopes) {
            PreparedStatement statement = connection
                    .prepare("delete from osiam_client_scopes where id = ? and scope = ?");
            
            BoundStatement bound;
            bound = statement.bind(internalId, scope);               
            connection.execute(bound);
        }
    }

    private void addScopesToClient(String clientId, String... scopes) throws Exception {
        long internalId = toInternalId(clientId);
        if (internalId < 0) {
            return;
        }
        for (String scope : scopes) {
            PreparedStatement statement = connection
                    .prepare("insert into osiam_client_scopes (id, scope) values (?, ?)");
 
            BoundStatement bound;
            bound = statement.bind(internalId, scope);               
            connection.execute(bound);
        }
    }

    private long toInternalId(String clientId) {
        if (!internalIds.containsKey(clientId)) {
        	try {
        	PreparedStatement statement = connection
                    .prepare("select internal_id from osiam_client where id = ?");
        	BoundStatement bound = statement.bind().setString(0, clientId);
            ResultSet resultSet = connection.execute(bound);  
            Row row = resultSet.one();
            if (null != row)  {
                    internalIds.put(clientId, row.getLong(1));
                } else {
                    internalIds.put(clientId, -1L);
                }
            } catch (Exception e) {
                internalIds.put(clientId, -1L);
            }
        }
        return internalIds.get(clientId);
    }
}
