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

package org.osiam.storage.query;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;

import org.osiam.resources.exception.InvalidConstraintException;
import org.osiam.resources.scim.MultiValuedAttributeType;
import org.osiam.storage.entities.ExtensionFieldEntity;

public enum FilterConstraint {
    EQUALS("eq") {
        @Override
        public String createPredicateForStringField(String path, String value, CriteriaBuilder cb) {
            return path + " = " + value;
        }

        @Override
        public String createPredicateForDateField(String path, Date value, CriteriaBuilder cb) {
            return path + " = " + value.toString();
        }

        @Override
        public String createPredicateForBooleanField(String path, Boolean value, CriteriaBuilder cb) {
            return path + " = " + value.toString();
        }

        @Override
        public String createPredicateForExtensionField(String path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public <T extends MultiValuedAttributeType> String createPredicateForMultiValuedAttributeTypeField(
        		String path, T value, CriteriaBuilder cb) {
            return createPredicateForStringField(path, value, cb);
        }

    },
    CONTAINS("co") {
        @Override
        public String createPredicateForStringField(String path, String value, CriteriaBuilder cb) {
            return path + " like %" + value + "%";
        }

        @Override
        public String createPredicateForDateField(String path, Date value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public String createPredicateForBooleanField(String path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public String createPredicateForExtensionField(String path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public <T extends MultiValuedAttributeType> String createPredicateForMultiValuedAttributeTypeField(
        		String path, T value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

    },
    STARTS_WITH("sw") {
        @Override
        public String createPredicateForStringField(String path, String value, CriteriaBuilder cb) {
            return path + " like " + value + "%";
        }

        @Override
        public String createPredicateForDateField(String path, Date value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public String createPredicateForBooleanField(String path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public String createPredicateForExtensionField(String path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public <T extends MultiValuedAttributeType> String createPredicateForMultiValuedAttributeTypeField(
        		String path, T value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }
    },
    PRESENT("pr") {
        @Override
        public String createPredicateForStringField(String path, String value, CriteriaBuilder cb) {
            return path + " IS NOT NULL AND " + path + "  != ''";
        }

        @Override
        public String createPredicateForDateField(String path, Date value, CriteriaBuilder cb) {
            return path + " IS NOT NULL";
        }

        @Override
        public String createPredicateForBooleanField(String path, Boolean value, CriteriaBuilder cb) {
            return " AND ";
        }

        @Override
        public String createPredicateForExtensionField(String path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public <T extends MultiValuedAttributeType> String createPredicateForMultiValuedAttributeTypeField(
        		String path, T value, CriteriaBuilder cb) {
            return path + " IS NOT NULL";
        }
    },
    GREATER_THAN("gt") {
        @Override
        public String createPredicateForStringField(String path, String value, CriteriaBuilder cb) {
            return path + " > " + value;
        }

        @Override
        public String createPredicateForDateField(String path, Date value, CriteriaBuilder cb) {
            return path + " > " + value.toString();
        }

        @Override
        public String createPredicateForBooleanField(String path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public String createPredicateForExtensionField(String path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public <T extends MultiValuedAttributeType> String createPredicateForMultiValuedAttributeTypeField(
        		String path, T value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }
    },
    GREATER_EQUALS("ge") {
        @Override
        public String createPredicateForStringField(String path, String value, CriteriaBuilder cb) {
            return path + " >= " + value;
        }

        @Override
        public String createPredicateForDateField(String path, Date value, CriteriaBuilder cb) {
            return path + " >= " + value.toString();
        }

        @Override
        public String createPredicateForBooleanField(String path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public String createPredicateForExtensionField(String path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public <T extends MultiValuedAttributeType> String createPredicateForMultiValuedAttributeTypeField(
        		String path, T value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

    },
    LESS_THAN("lt") {
        @Override
        public String createPredicateForStringField(String path, String value, CriteriaBuilder cb) {
            return path + " < " + value;
        }

        @Override
        public String createPredicateForDateField(String path, Date value, CriteriaBuilder cb) {
            return path + " < " + value.toString();
        }

        @Override
        public String createPredicateForBooleanField(String path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public String createPredicateForExtensionField(String path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public <T extends MultiValuedAttributeType> String createPredicateForMultiValuedAttributeTypeField(
        		String path, T value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }
    },
    LESS_EQUALS("le") {
        @Override
        public String createPredicateForStringField(String path, String value, CriteriaBuilder cb) {
            return path + " <= " + value;
        }

        @Override
        public String createPredicateForDateField(String path, Date value, CriteriaBuilder cb) {
            return path + " <= " + value.toString();
        }

        @Override
        public String createPredicateForBooleanField(String path, Boolean value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }

        @Override
        public String createPredicateForExtensionField(String path, String value, ExtensionFieldEntity field,
                CriteriaBuilder cb) {
            if (!field.isConstrainedValid(toString())) {
                throw new InvalidConstraintException(toString());
            }
            return createPredicateForStringField(path, value, cb);
        }

        @Override
        public <T extends MultiValuedAttributeType> String createPredicateForMultiValuedAttributeTypeField(
        		String path, T value, CriteriaBuilder cb) {
            throw new InvalidConstraintException(toString());
        }
    };

    private static final Map<String, FilterConstraint> STRING_TO_ENUM = new ConcurrentHashMap<>();

    static {
        for (final FilterConstraint constraint : values()) {
            STRING_TO_ENUM.put(constraint.toString(), constraint);
        }
    }

    private final String name;

    FilterConstraint(String constraint) {
        name = constraint;
    }

    public static FilterConstraint fromString(String name) {
        return STRING_TO_ENUM.get(name.toLowerCase(Locale.ENGLISH));
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract String createPredicateForStringField(String path, String value, CriteriaBuilder cb);

    public abstract String createPredicateForDateField(String path, Date value, CriteriaBuilder cb);

    public abstract String createPredicateForBooleanField(String path, Boolean value, CriteriaBuilder cb);

    public abstract <T extends MultiValuedAttributeType> String createPredicateForMultiValuedAttributeTypeField(
    		String path, T value, CriteriaBuilder cb);

    public abstract String createPredicateForExtensionField(String path, String value,
            ExtensionFieldEntity field, CriteriaBuilder cb);

}
