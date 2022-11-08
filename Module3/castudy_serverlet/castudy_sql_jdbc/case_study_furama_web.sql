DROP DATABASE IF EXISTS case_study_furama_web;
CREATE DATABASE case_study_furama_web;
USE case_study_furama_web;

CREATE TABLE position (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45)
);

CREATE TABLE division (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45)
);

CREATE TABLE education_degree (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45)
);

CREATE TABLE user (
username VARCHAR(255) PRIMARY KEY,
password VARCHAR(255)
);

CREATE TABLE role (
role_id INT AUTO_INCREMENT PRIMARY KEY,
role_name VARCHAR(255)
);

CREATE TABLE user_role (
    role_id INT,
    username VARCHAR(255),
    PRIMARY KEY (role_id , username),
    FOREIGN KEY (username)
        REFERENCES user (username)
        ON DELETE CASCADE,
    FOREIGN KEY (role_id)
        REFERENCES role (role_id)
        ON DELETE CASCADE
);

CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    day_of_birth DATE NOT NULL,
    id_card VARCHAR(45) UNIQUE NOT NULL,
    salary DOUBLE NOT NULL,
    phone_number VARCHAR(45) UNIQUE NOT NULL,
    email VARCHAR(45) UNIQUE,
    address VARCHAR(45),
    position_id INT,
    education_degree_id INT,
    division_id INT,
    username VARCHAR(255) UNIQUE,
    FOREIGN KEY (position_id)
        REFERENCES position (id)
        ON DELETE CASCADE,
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (id)
        ON DELETE CASCADE,
    FOREIGN KEY (division_id)
        REFERENCES division (id)
        ON DELETE CASCADE,
    FOREIGN KEY (username)
        REFERENCES user (username)
        ON DELETE CASCADE
);

CREATE TABLE customer_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45)
);

CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    day_of_birth DATE NOT NULL,
    gender BIT(1) NOT NULL,
    id_card VARCHAR(45) UNIQUE NOT NULL,
    phone_number VARCHAR(45) UNIQUE NOT NULL,
    email VARCHAR(45),
    address VARCHAR(45),
    customer_type_id INT,
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (id)
        ON DELETE CASCADE
);

CREATE TABLE facility_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45)
);

CREATE TABLE rent_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45)
);

CREATE TABLE facility (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    area INT,
    cost DOUBLE NOT NULL,
    max_people INT,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    facility_free TEXT,
    rent_type_id INT,
    facility_type_id INT,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (id)
        ON DELETE CASCADE,
    FOREIGN KEY (facility_type_id)
        REFERENCES facility_type (id)
        ON DELETE CASCADE
);

CREATE TABLE attach_facility (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    cost DOUBLE NOT NULL,
    unit VARCHAR(45) NOT NULL,
    status VARCHAR(45)
);

CREATE TABLE contract (
    id INT AUTO_INCREMENT PRIMARY KEY,
    start_day DATE NOT NULL,
    end_day DATE NOT NULL,
    deposit DOUBLE NOT NULL,
    employee_id INT,
    customer_id INT,
    facility_id INT,
    FOREIGN KEY (employee_id)
        REFERENCES employee (id)
        ON DELETE CASCADE,
    FOREIGN KEY (customer_id)
        REFERENCES customer (id)
        ON DELETE CASCADE,
    FOREIGN KEY (facility_id)
        REFERENCES facility (id)
        ON DELETE CASCADE
);

CREATE TABLE contract_detail (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantity INT NOT NULL,
    contract_id INT,
    attach_facility_id INT,
    FOREIGN KEY (contract_id)
        REFERENCES contract (id)
        ON DELETE CASCADE,
    FOREIGN KEY (attach_facility_id)
        REFERENCES attach_facility (id)
        ON DELETE CASCADE
);