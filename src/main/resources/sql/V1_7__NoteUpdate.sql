ALTER TABLE note ADD COLUMN dateadded datetime DEFAULT NULL AFTER trynick;
ALTER TABLE note ADD COLUMN datemodified datetime DEFAULT NULL AFTER dateadded;
ALTER TABLE note ADD COLUMN mailtosend BIT(1) NOT NULL DEFAULT 0 AFTER datemodified;
ALTER TABLE note ADD COLUMN wasmailsend BIT(1) NOT NULL DEFAULT 0 AFTER mailtosend;
ALTER TABLE note ADD COLUMN nickfound BIT(1) NOT NULL DEFAULT 0 AFTER wasmailsend;