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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.joda.time.format.ISODateTimeFormat;
import org.osiam.resources.scim.Address;
import org.osiam.resources.scim.Email;
import org.osiam.resources.scim.Entitlement;
import org.osiam.resources.scim.Im;
import org.osiam.resources.scim.PhoneNumber;
import org.osiam.resources.scim.Photo;
import org.osiam.storage.entities.AddressEntity;
import org.osiam.storage.entities.AddressEntity_;
import org.osiam.storage.entities.BaseMultiValuedAttributeEntityWithValue_;
import org.osiam.storage.entities.BaseMultiValuedAttributeEntity_;
import org.osiam.storage.entities.EmailEntity;
import org.osiam.storage.entities.EmailEntity_;
import org.osiam.storage.entities.EntitlementEntity;
import org.osiam.storage.entities.EntitlementEntity_;
import org.osiam.storage.entities.GroupEntity;
import org.osiam.storage.entities.GroupEntity_;
import org.osiam.storage.entities.ImEntity;
import org.osiam.storage.entities.ImEntity_;
import org.osiam.storage.entities.MetaEntity_;
import org.osiam.storage.entities.NameEntity;
import org.osiam.storage.entities.NameEntity_;
import org.osiam.storage.entities.PhoneNumberEntity;
import org.osiam.storage.entities.PhoneNumberEntity_;
import org.osiam.storage.entities.PhotoEntity;
import org.osiam.storage.entities.PhotoEntity_;
import org.osiam.storage.entities.ResourceEntity_;
import org.osiam.storage.entities.RoleEntity;
import org.osiam.storage.entities.RoleEntity_;
import org.osiam.storage.entities.UserEntity;
import org.osiam.storage.entities.UserEntity_;
import org.osiam.storage.entities.X509CertificateEntity;

public enum UserQueryField implements QueryField<UserEntity> {

    EXTERNALID("externalid") {
        @Override
        public Predicate addFilter(Root<UserEntity> root,
                FilterConstraint constraint, String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(ResourceEntity_.externalId), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(ResourceEntity_.externalId);
            return null;
        }
    },
    META_CREATED("meta.created") {
        @Override
        public Predicate addFilter(Root<UserEntity> root,
                FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	Date date = ISODateTimeFormat.dateTimeParser().parseDateTime(value).toDate();
            return constraint.createPredicateForDateField(root.get(ResourceEntity_.meta).get(MetaEntity_.created), date, cb);
            */
            return null;
      }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(ResourceEntity_.meta).get(MetaEntity_.created);
            return null;
       }
    },
    META_LASTMODIFIED("meta.lastmodified") {
        @Override
        public Predicate addFilter(Root<UserEntity> root,
                FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	Date date = ISODateTimeFormat.dateTimeParser().parseDateTime(value).toDate();
            return constraint.createPredicateForDateField(root.get(ResourceEntity_.meta).get(MetaEntity_.lastModified), date, cb);
            */
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(ResourceEntity_.meta).get(MetaEntity_.lastModified);
            return null;
        }
    },
    META_LOCATION("meta.location") {
        @Override
        public Predicate addFilter(Root<UserEntity> root,
                FilterConstraint constraint, String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(ResourceEntity_.meta).get(MetaEntity_.location), value, cb);
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(ResourceEntity_.meta).get(MetaEntity_.location);
            return null;
     }
    },
    USERNAME("username") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.userName), value, cb);
            return null;
      }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(UserEntity_.userName);
            return null;
     }

    },
    DISPLAYNAME("displayname") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.displayName), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(UserEntity_.displayName);
            return null;
        }

    },
    NICKNAME("nickname") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.nickName), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(UserEntity_.nickName);
            return null;
        }

    },
    PROFILEURL("profileurl") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.profileUrl), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(UserEntity_.profileUrl);
            return null;
        }

    },
    TITLE("title") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.title), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(UserEntity_.title);
            return null;
        }

    },
    USERTYPE("usertype") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.userType), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(UserEntity_.userType);
            return null;
        }

    },
    PREFERREDLANGUAGE("preferredlanguage") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.preferredLanguage), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(UserEntity_.preferredLanguage);
            return null;
        }

    },
    LOCALE("locale") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.locale), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(UserEntity_.locale);
            return null;
      }

    },
    TIMEZONE("timezone") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.timezone), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(UserEntity_.timezone);
            return null;
       }

    },
    ACTIVE("active") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForBooleanField(root.get(UserEntity_.active), Boolean.valueOf(value), cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return root.get(UserEntity_.active);
            return null;
        }

    },
    NAME_FORMATTED("name.formatted") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.name).get(NameEntity_.formatted), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return createOrGetJoinForName(root).get(NameEntity_.formatted);
            return null;
       }

    },
    NAME_FAMILYNAME("name.familyname") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.name).get(NameEntity_.familyName), value, cb);
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return createOrGetJoinForName(root).get(NameEntity_.familyName);
            return null;
       }

    },
    NAME_GIVENNAME("name.givenname") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.name).get(NameEntity_.givenName), value, cb);
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return createOrGetJoinForName(root).get(NameEntity_.givenName);
            return null;
        }
    },
    NAME_MIDDLENAME("name.middlename") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.name).get(NameEntity_.middleName), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return createOrGetJoinForName(root).get(NameEntity_.middleName);
            return null;
      }

    },
    NAME_HONORIFICPREFIX("name.honorificprefix") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.name).get(NameEntity_.honorificPrefix), value, cb);
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return createOrGetJoinForName(root).get(NameEntity_.honorificPrefix);
            return null;
        }

    },
    NAME_HONORIFICSUFFIX("name.honorificsuffix") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.name).get(NameEntity_.honorificSuffix), value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return createOrGetJoinForName(root).get(NameEntity_.honorificSuffix);
            return null;
        }

    },
    PASSWORD("password") {
        @Override
        public Predicate addFilter(Root<UserEntity> root,
                FilterConstraint constraint, String value, CriteriaBuilder cb) {
            //return constraint.createPredicateForStringField(root.get(UserEntity_.password), value, cb);
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    EMAILS("emails") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return EMAILS_VALUE.addFilter(root, constraint, value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return EMAILS_VALUE.createSortByField(root, cb);
            return null;
        }

    },
    EMAILS_VALUE("emails.value") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {

            /*
        	SetJoin<UserEntity, EmailEntity> join = root.join(UserEntity_.emails, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(BaseMultiValuedAttributeEntityWithValue_.value), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }

    },
    EMAILS_TYPE("emails.type") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	Email.Type emailType = null;

            if (constraint != FilterConstraint.PRESENT) {
                emailType = new Email.Type(value);
            }
            SetJoin<UserEntity, EmailEntity> join = root.join(UserEntity_.emails, JoinType.LEFT);
            return constraint.createPredicateForMultiValuedAttributeTypeField(join.get(EmailEntity_.type), emailType, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }

    },
    EMAILS_PRIMARY("emails.primary") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {

            /*
        	SetJoin<UserEntity, EmailEntity> join = root.join(UserEntity_.emails, JoinType.LEFT);
            return constraint.createPredicateForBooleanField(join.get(BaseMultiValuedAttributeEntity_.primary), Boolean.valueOf(value), cb);
            */
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }

    },
    PHONENUMBERS("phonenumbers") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return PHONENUMBERS_VALUE.addFilter(root, constraint, value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return PHONENUMBERS_VALUE.createSortByField(root, cb);
            return null;
       }
    },
    PHONENUMBERS_VALUE("phonenumbers.value") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, PhoneNumberEntity> join = root.join(UserEntity_.phoneNumbers, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(BaseMultiValuedAttributeEntityWithValue_.value), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    PHONENUMBERS_TYPE("phonenumbers.type") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	PhoneNumber.Type phoneNumberType = null;

            if (constraint != FilterConstraint.PRESENT) {
                phoneNumberType = new PhoneNumber.Type(value);
            }
            SetJoin<UserEntity, PhoneNumberEntity> join = root.join(UserEntity_.phoneNumbers, JoinType.LEFT);
            return constraint.createPredicateForMultiValuedAttributeTypeField(join.get(PhoneNumberEntity_.type), phoneNumberType, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    PHONENUMBERS_PRIMARY("phonenumbers.primary") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, PhoneNumberEntity> join = root.join(UserEntity_.phoneNumbers, JoinType.LEFT);
            return constraint.createPredicateForBooleanField(join.get(PhoneNumberEntity_.primary), Boolean.valueOf(value), cb);
            */
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    IMS("ims") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return IMS_VALUE.addFilter(root, constraint, value, cb);
            return null;
      }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return IMS_VALUE.createSortByField(root, cb);
            return null;
       }
    },
    IMS_VALUE("ims.value") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, ImEntity> join = root.join(UserEntity_.ims, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(BaseMultiValuedAttributeEntityWithValue_.value), value, cb);
            */
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }

    },
    IMS_TYPE("ims.type") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	Im.Type imType = null;

            if (constraint != FilterConstraint.PRESENT) {
                imType = new Im.Type(value);
            }

            SetJoin<UserEntity, ImEntity> join = root.join(UserEntity_.ims, JoinType.LEFT);
            return constraint.createPredicateForMultiValuedAttributeTypeField(join.get(ImEntity_.type), imType, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    IMS_PRIMARY("ims.primary") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, ImEntity> join = root.join(UserEntity_.ims, JoinType.LEFT);
            return constraint.createPredicateForBooleanField(join.get(ImEntity_.primary), Boolean.valueOf(value), cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    PHOTOS("photos") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return PHOTOS_VALUE.addFilter(root, constraint, value, cb);
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return PHOTOS_VALUE.createSortByField(root, cb);
            return null;
       }
    },
    PHOTOS_VALUE("photos.value") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, PhotoEntity> join = root.join(UserEntity_.photos, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(BaseMultiValuedAttributeEntityWithValue_.value), value, cb);
            */
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    PHOTOS_TYPE("photos.type") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	Photo.Type photoType = null;

            if (constraint != FilterConstraint.PRESENT) {
                photoType = new Photo.Type(value);
            }

            SetJoin<UserEntity, PhotoEntity> join = root.join(UserEntity_.photos, JoinType.LEFT);
            return constraint.createPredicateForMultiValuedAttributeTypeField(join.get(PhotoEntity_.type), photoType, cb);
            */
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    PHOTOS_PRIMARY("photos.primary") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, PhotoEntity> join = root.join(UserEntity_.photos, JoinType.LEFT);
            return constraint.createPredicateForBooleanField(join.get(PhotoEntity_.primary), Boolean.valueOf(value), cb);
            */
            return null;
      }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ADDRESSES_REGION("addresses.region") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, AddressEntity> join = root.join(UserEntity_.addresses, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(AddressEntity_.region), value, cb);
            */
            return null;
      }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ADDRESSES_STREETADDRESS("addresses.streetaddress") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, AddressEntity> join = root.join(UserEntity_.addresses, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(AddressEntity_.streetAddress), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ADDRESSES_FORMATTED("addresses.formatted") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, AddressEntity> join = root.join(UserEntity_.addresses, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(AddressEntity_.formatted), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ADDRESSES_POSTALCODE("addresses.postalcode") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, AddressEntity> join = root.join(UserEntity_.addresses, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(AddressEntity_.postalCode), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ADDRESSES_LOCALITY("addresses.locality") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, AddressEntity> join = root.join(UserEntity_.addresses, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(AddressEntity_.locality), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ADDRESSES_TYPE("addresses.type") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	Address.Type addressType = null;

            if (constraint != FilterConstraint.PRESENT) {
                addressType = new Address.Type(value);
            }

            SetJoin<UserEntity, AddressEntity> join = root.join(UserEntity_.addresses, JoinType.LEFT);
            return constraint.createPredicateForMultiValuedAttributeTypeField(join.get(AddressEntity_.type), addressType, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ADDRESSES_COUNTRY("addresses.country") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, AddressEntity> join = root.join(UserEntity_.addresses, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(AddressEntity_.country), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ADDRESSES_PRIMARY("addresses.primary") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, AddressEntity> join = root.join(UserEntity_.addresses, JoinType.LEFT);
            return constraint.createPredicateForBooleanField(join.get(AddressEntity_.primary), Boolean.valueOf(value), cb);
            */
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ENTITLEMENTS("entitlements") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return ENTITLEMENTS_VALUE.addFilter(root, constraint, value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return ENTITLEMENTS_VALUE.createSortByField(root, cb);
            return null;
        }
    },
    ENTITLEMENTS_VALUE("entitlements.value") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, EntitlementEntity> join = root.join(UserEntity_.entitlements, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(BaseMultiValuedAttributeEntityWithValue_.value), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ENTITLEMENTS_TYPE("entitlements.type") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	Entitlement.Type type = null;

            if (constraint != FilterConstraint.PRESENT) {
                type = new Entitlement.Type(value);
            }

            SetJoin<UserEntity, EntitlementEntity> join = root.join(UserEntity_.entitlements, JoinType.LEFT);
            return constraint.createPredicateForMultiValuedAttributeTypeField(join.get(EntitlementEntity_.type), type, cb);
            */
            return null;
       }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ENTITLEMENTS_PRIMARY("entitlements.primary") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, EntitlementEntity> join = root.join(UserEntity_.entitlements, JoinType.LEFT);
            return constraint.createPredicateForBooleanField(join.get(EntitlementEntity_.primary), Boolean.valueOf(value), cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ROLES("roles") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return ROLES_VALUE.addFilter(root, constraint, value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return ROLES_VALUE.createSortByField(root, cb);
            return null;
        }
    },
    ROLES_VALUE("roles.value") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, RoleEntity> join = root.join(UserEntity_.roles, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(BaseMultiValuedAttributeEntityWithValue_.value), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    ROLES_PRIMARY("roles.primary") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint, String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, RoleEntity> join = root.join(UserEntity_.roles, JoinType.LEFT);
            return constraint.createPredicateForBooleanField(join.get(RoleEntity_.primary), Boolean.valueOf(value), cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    X509CERTIFICATES("x509certificates") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return X509CERTIFICATES_VALUE.addFilter(root, constraint, value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return X509CERTIFICATES_VALUE.createSortByField(root, cb);
            return null;
        }
    },
    X509CERTIFICATES_VALUE("x509certificates.value") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	SetJoin<UserEntity, X509CertificateEntity> join = root.join(UserEntity_.x509Certificates, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(BaseMultiValuedAttributeEntityWithValue_.value), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    GROUPS("groups") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            //return GROUPS_VALUE.addFilter(root, constraint, value, cb);
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            //return GROUPS_VALUE.createSortByField(root, cb);
            return null;
        }
    },
    GROUPS_VALUE("groups.value") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	final SetJoin<UserEntity, GroupEntity> join = root.join(ResourceEntity_.groups, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(ResourceEntity_.id), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    },
    GROUPS_DISPLAY("groups.display") {
        @Override
        public Predicate addFilter(Root<UserEntity> root, FilterConstraint constraint,
                String value, CriteriaBuilder cb) {
            /*
        	final SetJoin<UserEntity, GroupEntity> join = root.join(ResourceEntity_.groups, JoinType.LEFT);
            return constraint.createPredicateForStringField(join.get(GroupEntity_.displayName), value, cb);
            */
            return null;
        }

        @Override
        public Expression<?> createSortByField(Root<UserEntity> root, CriteriaBuilder cb) {
            throw handleSortByFieldNotSupported(toString());
        }
    };

    private static final Map<String, UserQueryField> STRING_TO_ENUM = new HashMap<>();

    private static final String JOIN_ALIAS_FOR_NAME = "nameJoin";

    static {
        for (UserQueryField filterField : values()) {
            STRING_TO_ENUM.put(filterField.toString(), filterField);
        }
    }

    private final String name;

    UserQueryField(String name) {
        this.name = name;
    }

    public static UserQueryField fromString(String name) {
        return STRING_TO_ENUM.get(name);
    }

    protected RuntimeException handleSortByFieldNotSupported(String fieldName) {
        throw new RuntimeException("Sorting by " + fieldName + " is not supported yet");
    }

    @SuppressWarnings("unchecked")
    protected Join<UserEntity, NameEntity> createOrGetJoinForName(final Root<UserEntity> root) {

        /*
    	for (final Join<UserEntity, ?> currentJoin : root.getJoins()) {
            if (currentJoin.getAlias() != null && currentJoin.getAlias().equals(JOIN_ALIAS_FOR_NAME)) {
                return (Join<UserEntity, NameEntity>) currentJoin;
            }
        }

        Join<UserEntity, NameEntity> join = root.join(UserEntity_.name, JoinType.LEFT);
        join.alias(JOIN_ALIAS_FOR_NAME);

        return join;
        */
        
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
