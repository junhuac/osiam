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

package org.osiam.storage.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@MappedSuperclass
public abstract class BaseMultiValuedAttributeEntity {

    private static final int SEQUENCE_ALLOCATION_SIZE = 1;
    private static final int SEQUENCE_INITIAL_VALUE = 100;

    @Id
    @TableGenerator(name = "sequence_scim_multi_valued_attribute",
    		table = "resource_server_sequence_scim_multi_valued_attribute",
    		pkColumnName="GEN_KEY",
    		valueColumnName="GEN_VALUE",
    		pkColumnValue="SCIM_ID",
            allocationSize = SEQUENCE_ALLOCATION_SIZE,
            initialValue = SEQUENCE_INITIAL_VALUE)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sequence_scim_multi_valued_attribute")
    private long multiValueId;

    @Column(name = "is_primary")
    private Boolean primary;

    public long getMultiValueId() {
        return multiValueId;
    }

    public void setMultiValueId(long id) {
        this.multiValueId = id;
    }

    public boolean isPrimary() {
        if (primary == null) {
            return false;
        }
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
}
