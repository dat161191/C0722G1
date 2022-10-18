USE sales_manager;

INSERT INTO customer (c_id,c_name,c_age)
VALUES
  (1,'Minh Quan',10),
  (2,'Ngoc Oanh',20),
  (3,'Hong Ha',50);
  
  INSERT INTO oder(o_id,c_id,o_date,o_total_price)
  VALUES
	(1,1,"2006-03-21",NULL),
	(2,2,"2006-03-23",NULL),
	(3,1,"2006-03-16",NULL);
  
INSERT INTO product(p_id,p_name,p_price)
VALUES
  (1,'Máy Giặt',3),
  (2,'Tủ Lạnh',5),
  (3,'Điều Hòa',7),
  (4,'Quạt',1),
  (5,'Bếp Điện',2);
  
INSERT INTO oder_dentail(o_id,p_id,o_qty)
VALUES
  (1,1,3),
  (1,3,7),
  (1,4,2),
  (2,1,1),
  (3,1,8),
  (2,5,4),
  (2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT oder.o_id,oder.o_date,oder.o_total_price
FROM oder;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT 
    customer.c_name, product.p_name
FROM
    (oder_dentail
    JOIN oder ON oder_dentail.o_id = oder.o_id
    JOIN product ON oder_dentail.p_id = product.p_id)
        JOIN
    customer ON oder.c_id = customer.c_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT 
    customer.c_name, oder.c_id
FROM
    customer
        LEFT JOIN
    oder ON customer.c_id = oder.c_id
WHERE
    oder.c_id IS NULL;
-- SELECT customer.c_name
-- FROM customer
-- WHERE NOT EXISTS 
-- (SELECT customer.c_id FROM oder WHERE customer.c_id = oder.c_id)

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
--  Giá bán của từng loại được tính = odQTY*pPrice)
SELECT 
    oder.o_id,
    oder.o_date,
    oder_dentail.o_qty * product.p_price AS tong_tien
FROM
    (oder_dentail
    JOIN oder ON oder_dentail.o_id = oder.o_id)
        JOIN
    product ON oder_dentail.p_id = product.p_id;

