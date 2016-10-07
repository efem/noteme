CREATE TABLE users_roles (
  userid bigint(20) NOT NULL,
  roleid bigint(20) NOT NULL,
  KEY FK_roles_id_01 (roleid),
  KEY FK_users_id_01 (userid),
  CONSTRAINT FK_roles_id_01 FOREIGN KEY (roleid) REFERENCES roles (id),
  CONSTRAINT FK_users_id_01 FOREIGN KEY (userid) REFERENCES users (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO users_roles (userid, roleid) VALUES (1, 1);
INSERT INTO users_roles (userid, roleid) VALUES (1, 2);
INSERT INTO users_roles (userid, roleid) VALUES (1, 3);

INSERT INTO users_roles (userid, roleid) VALUES (2, 1);
INSERT INTO users_roles (userid, roleid) VALUES (2, 2);
INSERT INTO users_roles (userid, roleid) VALUES (2, 3);

INSERT INTO users_roles (userid, roleid) VALUES (3, 1);
INSERT INTO users_roles (userid, roleid) VALUES (3, 2);

INSERT INTO users_roles (userid, roleid) VALUES (4, 1);
INSERT INTO users_roles (userid, roleid) VALUES (4, 2);

INSERT INTO users_roles (userid, roleid) VALUES (5, 1);
