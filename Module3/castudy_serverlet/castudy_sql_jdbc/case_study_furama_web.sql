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
    is_delete BIT(1) DEFAULT 0,
    FOREIGN KEY (username)
        REFERENCES user (username),
    FOREIGN KEY (role_id)
        REFERENCES role (role_id)
);

CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    date_of_birth DATE ,
    id_card VARCHAR(45),
    salary DOUBLE NOT NULL,
    phone_number VARCHAR(45),
    email VARCHAR(45),
    address VARCHAR(45),
    position_id INT,
    education_degree_id INT,
    division_id INT,
    username VARCHAR(255) ,
    is_delete BIT(1) DEFAULT 0,
    FOREIGN KEY (position_id)
        REFERENCES position (id),
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (id),
    FOREIGN KEY (division_id)
        REFERENCES division (id),
    FOREIGN KEY (username)
        REFERENCES user (username)
);

CREATE TABLE customer_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45)
);

CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    date_of_birth DATE,
    gender BIT(1),
    id_card VARCHAR(45),
    phone_number VARCHAR(45),
    email VARCHAR(45),
    address VARCHAR(45),
    customer_type_id INT,
    is_delete BIT(1) DEFAULT 0,
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (id)
   
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
    name VARCHAR(45) ,
    area INT,
    cost DOUBLE ,
    max_people INT,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    facility_free TEXT,
    rent_type_id INT,
    facility_type_id INT,
    is_delete BIT(1) DEFAULT 0,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (id),
    FOREIGN KEY (facility_type_id)
        REFERENCES facility_type (id)
);

CREATE TABLE attach_facility (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    cost DOUBLE,
    unit VARCHAR(45),
    status VARCHAR(45)
);

CREATE TABLE contract (
    id INT AUTO_INCREMENT PRIMARY KEY,
    start_day DATE,
    end_day DATE ,
    deposit DOUBLE ,
    employee_id INT,
    customer_id INT,
    facility_id INT,
    is_delete BIT(1) DEFAULT 0,
    FOREIGN KEY (employee_id)
        REFERENCES employee (id),
    FOREIGN KEY (customer_id)
        REFERENCES customer (id),
    FOREIGN KEY (facility_id)
        REFERENCES facility (id)

);

CREATE TABLE contract_detail (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantity INT,
    contract_id INT,
    attach_facility_id INT,
    FOREIGN KEY (contract_id)
        REFERENCES contract (id),
    FOREIGN KEY (attach_facility_id)
        REFERENCES attach_facility (id)
);
-- SELECT facility.*, rent_type.name AS rent_type_name, facility_type.name AS facility_type_name FROM facility JOIN rent_type ON facility.rent_type_id = rent_type.id JOIN facility_type ON facility.facility_type_id = facility_type.id WHERE facility.is_delete = 0;
#====== QUERY HIỂN THỊ TẤT CẢ THÔNG TIN CUSTOMER ======#
DELIMITER //
CREATE PROCEDURE select_customers()
BEGIN
	SELECT c.*,ct.name as customer_type_name FROM customer c LEFT JOIN customer_type ct ON c.customer_type_id = ct.id WHERE is_delete =0;
END //
DELIMITER ;
CALL select_customers();
#=========QUERY TÌM THEO ID==============#
DELIMITER //
CREATE PROCEDURE find_by_id(IN id INT)
BEGIN
	SELECT * FROM customer WHERE is_delete =0 AND customer.id = id;
END//
DELIMITER ;