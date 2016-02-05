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

import org.hibernate.annotations.Type;
import org.osiam.resources.exception.InvalidConstraintException;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Defines a SCIM-Extension.
 */
@Entity
@Table(name = "scim_extension",
        indexes = {
                @Index(unique = true, columnList = "urn")})
public class ExtensionEntity {

    @Id
    @TableGenerator(name = "sequence_scim_extension",
    		table = "resource_server_sequence_scim_extension",
	    	pkColumnName="GEN_KEY",
	    	valueColumnName="GEN_VALUE",
	    	pkColumnValue="SCIM_ID",
            allocationSize = 1,
            initialValue = 100)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sequence_scim_extension")
    private long internalId;

    @Lob
    @Column(nullable = false)
    private String urn;

    @OneToMany(mappedBy = "extension")
    private Set<ExtensionFieldEntity> fields = new HashSet<>();

    public long getInternalId() {
        return internalId;
    }

    public void setInternalId(long internalId) {
        this.internalId = internalId;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String extensionUrn) {
        this.urn = extensionUrn;
    }

    public Set<ExtensionFieldEntity> getFields() {
        if (fields == null) {
            fields = new HashSet<>();
        }
        return fields;
    }

    public void setFields(Set<ExtensionFieldEntity> extensionFields) {
        if (extensionFields != null) {
            for (ExtensionFieldEntity extensionFieldEntity : extensionFields) {
                extensionFieldEntity.setExtension(this);
            }
        }
        this.fields = extensionFields;
    }

    public ExtensionFieldEntity getFieldForName(String fieldName, boolean caseInsensitive) {
        for (ExtensionFieldEntity field : fields) {
            if (!caseInsensitive) {
                if (field.getName().equals(fieldName)) {
                    return field;
                }
            } else {
                if (field.getName().equalsIgnoreCase(fieldName)) {
                    return field;
                }
            }
        }

        throw new InvalidConstraintException(String.format("Field '%s' not available in extension with urn '%s'",
                fieldName, urn));
    }

    public ExtensionFieldEntity getFieldForName(String fieldName) {
        return getFieldForName(fieldName, false);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((urn == null) ? 0 : urn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ExtensionEntity other = (ExtensionEntity) obj;
        if (urn == null) {
            if (other.urn != null) {
                return false;
            }
        } else if (!urn.equals(other.urn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExtensionEntity [urn=" + urn + "]";
    }

}
