DROP DATABASE IF EXISTS sales_manager;
CREATE DATABASE IF NOT EXISTS sales_manager;
USE sales_manager;

CREATE TABLE customer (
    c_id INT PRIMARY KEY,
    c_name VARCHAR(50) NOT NULL,
    c_age INT NOT NULL
);

CREATE TABLE product (
    p_id INT PRIMARY KEY,
    p_name VARCHAR(50) NOT NULL,
    p_price DOUBLE NOT NULL
);

CREATE TABLE oder (
    o_id INT PRIMARY KEY,
    c_id INT NOT NULL,
    o_date DATE NOT NULL,
    o_total_price DOUBLE NULL,
    CONSTRAINT fk_customer FOREIGN KEY (c_id)
        REFERENCES customer (c_id)
);

CREATE TABLE oder_dentail (
    o_id INT NOT NULL,
    p_id INT NOT NULL,
    o_qty INT NOT NULL,
    PRIMARY KEY (o_id , p_id),
    CONSTRAINT fk_oder FOREIGN KEY (o_id)
        REFERENCES oder (o_id),
    CONSTRAINT fk_product FOREIGN KEY (p_id)
        REFERENCES product (p_id)
);

