--
-- Group 'admin' for the addon-administration. Has to be imported in the
-- database of OSIAM.
--

USE osiam;

INSERT INTO scim_meta (id, created, "lastModified", location, "resourceType", version) VALUES (2, dateof(now()), dateof(now()), NULL, 'Group', NULL);

insert into resource_server_sequence_scim_meta ("GEN_KEY", "GEN_VALUE") values ('SCIM_ID', 2);

INSERT INTO scim_group ("internalId", "displayName", "externalId", id, meta_id) VALUES (2, 'admin', NULL, 'cef9452e-00a9-4cec-a086-d171374aabef', 2);

insert into resource_server_sequence_scim_id ("GEN_KEY", "GEN_VALUE") values ('SCIM_ID', 2);

-- add default admin user to group

INSERT INTO scim_group_scim_id ("groups_internalId", "members_internalId") VALUES (2, 1);
