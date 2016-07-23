CREATE TABLE note (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  content varchar(255) NOT NULL,
  nickfound bit(1) NOT NULL,
  trynick varchar(255) NOT NULL,
  userid bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_user_id_02 (userid),
  CONSTRAINT FK_user_id_02 FOREIGN KEY (userid) REFERENCES users (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
