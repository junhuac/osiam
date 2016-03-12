--
-- Example self-administration client, please sync with the attribute values in
-- the addon-self-administration.properties. Has to be imported in the database
-- of OSIAM, before you deploy the addon-self-administration!
--

USE osiam;

INSERT INTO osiam_client ("internalId", "accessTokenValiditySeconds", "clientSecret", id, implicit_approval, "redirectUri", "refreshTokenValiditySeconds", "validityInSeconds") VALUES (10, 300, 'super-secret', 'addon-self-administration-client', FALSE, 'http://localhost:8080/addon-self-administration', 0, 0);

insert into auth_server_sequence_osiam_client ("GEN_KEY", "GEN_VALUE") values ('SCIM_ID', 10);

INSERT INTO osiam_client_scopes (id, scope) VALUES (10, 'ADMIN');
INSERT INTO osiam_client_grants (id, grants) VALUES (10, 'client_credentials');
