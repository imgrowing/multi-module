/*
CREATE DATABASE db1;
CREATE DATABASE db2;

USE mysql;

CREATE USER 'user1'@'%' IDENTIFIED BY 'user1';
CREATE USER 'user1'@'localhost' IDENTIFIED BY 'user1';

GRANT ALL PRIVILEGES ON db1.* TO 'user1'@'%' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON db1.* TO 'user1'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

USE mysql;

CREATE USER 'user2'@'%' IDENTIFIED BY 'user2';
CREATE USER 'user2'@'localhost' IDENTIFIED BY 'user2';

GRANT ALL PRIVILEGES ON db2.* TO 'user2'@'%' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON db2.* TO 'user2'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
 */

USE db1;

DROP TABLE IF EXISTS member;
CREATE TABLE member
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30),
    email       VARCHAR(30),
    nickname    VARCHAR(30),
    PRIMARY KEY (id)
) ENGINE = InnoDB;


USE db2;

DROP TABLE IF EXISTS product;
CREATE TABLE product
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30),
    price       INTEGER,
    PRIMARY KEY (id)
) ENGINE = InnoDB;