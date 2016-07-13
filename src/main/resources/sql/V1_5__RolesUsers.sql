CREATE TABLE roles_users (
  roles_id bigint(25) NOT NULL,
  users_id bigint(25) NOT NULL,
  KEY FK_users_id_01 (users_id),
  KEY FK_roles_id_01 (roles_id),
  CONSTRAINT FK_users_id_01 FOREIGN KEY (users_id) REFERENCES users (id),
  CONSTRAINT FK_roles_id_01 FOREIGN KEY (roles_id) REFERENCES roles (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;