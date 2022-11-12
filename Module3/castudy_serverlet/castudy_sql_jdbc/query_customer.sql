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
	SELECT 
		c.*, 
		t.name AS type_customer_name
	FROM 
		customer c LEFT JOIN customer_type t ON c.customer_type_id = t.id
	WHERE
		c.id = id;
END//
DELIMITER ;