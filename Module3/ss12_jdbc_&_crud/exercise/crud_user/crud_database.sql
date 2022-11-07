DROP DATABASE IF EXISTS user_database;
CREATE DATABASE IF NOT EXISTS user_database;
USE user_database;
CREATE TABLE users (
id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id));
 insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam'),('Kante','kante@che.uk','Kenia');

