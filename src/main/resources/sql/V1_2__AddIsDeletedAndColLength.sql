ALTER TABLE users CHANGE COLUMN password password VARCHAR(60) NOT NULL ;

ALTER TABLE users ADD COLUMN isDeleted BIT(1) NOT NULL AFTER password;
