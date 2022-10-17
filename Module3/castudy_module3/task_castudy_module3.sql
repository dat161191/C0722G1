USE castudty_module3;
-- Task 2
-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.--  
SELECT * FROM nhan_vien
WHERE (ho_ten LIKE "H%" OR ho_ten LIKE "K%" OR ho_ten LIKE "T%") AND char_length(ho_ten) <16;

-- Task 3--  
-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT * FROM khach_hang
-- WHERE 18 <= datediff(curdate(),ngay_sinh)/365.25 and datediff(curdate(),ngay_sinh)/365.25 <=50 
-- AND dia_chi LIKE "%Đà Nẵng%" OR dia_chi LIKE "%Quảng Trị%";
WHERE TIMESTAMPDIFF(YEAR,ngay_sinh,NOW()) >18 AND TIMESTAMPDIFF(YEAR,ngay_sinh,NOW()) <50 AND dia_chi REGEXP('(Quảng trị|Đà Nẵng)');


-- Task 4--  
-- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”
SELECT 	ho_ten,	khach_hang.ma_khach_hang,COUNT(hop_dong.ma_hop_dong) AS so_lan_dat_phong
FROM khach_hang JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
WHERE khach_hang.ma_loai_khach=1
GROUP BY (khach_hang.ma_khach_hang)
ORDER BY so_lan_dat_phong

-- Task 5 -- 


