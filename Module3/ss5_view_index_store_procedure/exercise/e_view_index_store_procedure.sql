-- b1
DROP DATABASE IF EXISTS excercise;
CREATE DATABASE IF NOT EXISTS excercise;
USE excercise;

-- b2
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_code INT,
    product_name VARCHAR(50),
    product_price FLOAT,
    product_amount INT,
    product_description VARCHAR(255),
    product_status VARCHAR(255)
);
INSERT INTO products(product_code,
product_name,
product_price ,
product_amount ,
product_description,
product_status)
VALUE
	(10,'cam',10000,10,'c','còn hàng'),
	(20,'táo',19000,11,'t','còn hàng'),
	(30,'ổi',30000,12,'o','còn hàng'),
	(40,'xoài',25000,13,'x','còn hàng'),
	(50,'mận',15000,9,'ma','hết hàng'),
	(60,'bưởi',18000,7,'b','còn hàng');

-- b3
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
	ALTER TABLE products ADD INDEX idx_product_code(product_code);
	EXPLAIN SELECT * FROM products WHERE product_code=20;
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
	ALTER TABLE products ADD INDEX idx_name_price (product_name,product_price);
    EXPLAIN SELECT * FROM products WHERE product_name = 'ổi' and product_price='30000';
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
-- So sánh câu truy vấn trước và sau khi tạo index

-- b4
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE VIEW products_view AS
SELECT 
product_code,
product_name,
product_price,
product_status
FROM products;
-- Tiến hành sửa đổi view
CREATE OR REPLACE VIEW products_view AS
SELECT product_description
FROM products;
-- Tiến hành xoá view
DROP VIEW products_view;

-- b5
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
	CREATE PROCEDURE sp_get_all_info_products()
    BEGIN
    SELECT * FROM products;
    END //
DELIMITER ;
CALL sp_get_all_info_products();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
	CREATE PROCEDURE sp_insert_products(IN product_code INT,product_name VARCHAR(50),product_price FLOAT ,product_amount INT,product_description VARCHAR(255),product_status VARCHAR(255))
    BEGIN
    INSERT INTO products(product_code,
	product_name,
	product_price ,
	product_amount ,
	product_description,
	product_status)
	VALUE
	(product_code,product_name,product_price,product_amount,product_description,product_status);
    END //
DELIMITER ;
	CALL sp_insert_products(70,'quýt',16000,20,'q','còn hàng');

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
	CREATE PROCEDURE sp_edit_info_products(IN pro_duct_name VARCHAR(50),IN product_code INT)
    BEGIN
    UPDATE products 
    SET product_name = pro_duct_name
    WHERE product_code = product_code;
    END //
DELIMITER ;
SET SQL_SAFE_UPDATES = 0;
	CALL sp_edit_info_products('Lê',60);
SET SQL_SAFE_UPDATES = 1;
-- Tạo store procedure xoá sản phẩm theo code
DELIMITER //
	CREATE PROCEDURE sp_delete_products(IN p_code INT)
    BEGIN
DELETE FROM products 
WHERE
    product_code = p_code;
    END //
DELIMITER ;
	CALL sp_delete_products(10);
