--
-- OAuth Client: please sync to the attribute values in the
-- addon-administration.properties. Has to be imported in the database of the
-- auth-server, before you deploy the addon-administration!
--

USE osiam;

INSERT INTO osiam_client ("internalId", "accessTokenValiditySeconds", "clientSecret", id, implicit_approval, "redirectUri", "refreshTokenValiditySeconds", "validityInSeconds") VALUES (20, 28800, 'super-secret', 'addon-administration-client', TRUE, 'http://localhost:8080/addon-administration', 0, 0);

insert into auth_server_sequence_osiam_client ("GEN_KEY", "GEN_VALUE") values ('SCIM_ID', 20);

CREATE TABLE IF NOT EXISTS osiam_client_grants (
    id bigint PRIMARY KEY,
    grants text
);

INSERT INTO osiam_client_scopes (id, scope) VALUES (20, 'ADMIN');
INSERT INTO osiam_client_grants (id, grants) VALUES (20, 'authorization_code');
