CREATE TABLE roles (
  id BIGINT(25) NOT NULL AUTO_INCREMENT,
  rolename VARCHAR(30) NOT NULL,
  PRIMARY KEY (id));
  
INSERT INTO roles (rolename) VALUES ("ADMIN");
INSERT INTO roles (rolename) VALUES ("MOD");
INSERT INTO roles (rolename) VALUES ("USER");
