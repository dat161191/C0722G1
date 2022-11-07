DROP DATABASE IF EXISTS user_database;
CREATE DATABASE IF NOT EXISTS user_database;
USE user_database;
CREATE TABLE users (
    id INT(3) NOT NULL AUTO_INCREMENT,
    name VARCHAR(120) NOT NULL,
    email VARCHAR(220) NOT NULL,
    country VARCHAR(120),
    PRIMARY KEY (id)
);
 insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam'),('Kante','kante@che.uk','Kenia');

