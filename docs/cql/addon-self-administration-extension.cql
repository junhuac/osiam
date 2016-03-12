--
-- Extension that stores the one time tokens for all mechanisms. Has to be imported in the
-- database of OSIAM, before you deploy the addon-self-administration!
--

USE osiam;

INSERT INTO scim_extension ("internalId", urn) VALUES (5, 'urn:org.osiam:scim:extensions:addon-self-administration');

insert into resource_server_sequence_scim_extension ("GEN_KEY", "GEN_VALUE") values ('SCIM_ID', 5);

INSERT INTO scim_extension_field ("internalId", extension, name, required, type) VALUES (6, 5, 'activationToken', FALSE, 'STRING');
INSERT INTO scim_extension_field ("internalId", extension, name, required, type) VALUES (7, 5, 'oneTimePassword', FALSE, 'STRING');
INSERT INTO scim_extension_field ("internalId", extension, name, required, type) VALUES (8, 5, 'emailConfirmToken', FALSE, 'STRING');
INSERT INTO scim_extension_field ("internalId", extension, name, required, type) VALUES (9, 5, 'tempMail', FALSE, 'STRING');

insert into resource_server_sequence_scim_extension_field ("GEN_KEY", "GEN_VALUE") values ('SCIM_ID', 9);
