CREATE TABLE users (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  username VARCHAR(16) NOT NULL,
  email VARCHAR(25) NOT NULL,
  password VARCHAR(20) NOT NULL,
  loginDate datetime DEFAULT NULL,
  regDate datetime DEFAULT NULL,
  PRIMARY KEY (id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;