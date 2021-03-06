CREATE TABLE IF NOT EXISTS users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (username)
);
   
CREATE TABLE IF NOT EXISTS authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
);

 CREATE TABLE oauth_client_details (
     client_id VARCHAR(256) PRIMARY KEY,
     resource_ids VARCHAR(256),
     client_secret VARCHAR(256),
     scope VARCHAR(256),
     authorized_grant_types VARCHAR(256),
     web_server_redirect_uri VARCHAR(256),
     authorities VARCHAR(256),
     access_token_validity INTEGER,
     refresh_token_validity INTEGER,
     additional_information VARCHAR(4096),
     autoapprove VARCHAR(256)
 );
 CREATE TABLE oauth_client_token (
     token_id VARCHAR(256),
     token blob,
     authentication_id VARCHAR(256),
     user_name VARCHAR(256),
     client_id VARCHAR(256)
 );
 CREATE TABLE oauth_access_token (
     token_id VARCHAR(256),
     token blob,
     authentication_id VARCHAR(256),
     user_name VARCHAR(256),
     client_id VARCHAR(256),
     authentication blob,
     refresh_token VARCHAR(256)
 );

 CREATE TABLE oauth_refresh_token (
     token_id VARCHAR(256),
     token blob,
     authentication blob
 );

 CREATE TABLE oauth_code (
     code VARCHAR(256), authentication blob
 );

