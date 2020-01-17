INSERT INTO oauth_client_details
(client_id, client_secret, scope, authorized_grant_types,
 web_server_redirect_uri, authorities, access_token_validity,
 refresh_token_validity, additional_information, autoapprove)
VALUES
  ('trusted-app', 'secret', 'read,write',
   'password,client_credentials,refresh_token', NULL, NULL, 86400, 2592000, NULL, TRUE);