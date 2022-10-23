USE castudty_module3;
-- Task 4 CÂU 2
-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.--  
SELECT 
    *
FROM
    nhan_vien
WHERE
    (ho_ten LIKE 'h%' OR ho_ten LIKE 'K%'
        OR ho_ten LIKE 'Tòng%')
        AND CHAR_LENGTH(ho_ten) < 16;
        
        
#=====Task 4 CÂU 2        
#  Hiển thị thông tinkhách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT * FROM khach_hang
-- WHERE 18 <= datediff(curdate(),ngay_sinh)/365.25 and datediff(curdate(),ngay_sinh)/365.25 <=50 
-- AND dia_chi LIKE "%Đà Nẵng%" OR dia_chi LIKE "%Quảng Trị%";
WHERE TIMESTAMPDIFF(YEAR,ngay_sinh,NOW()) >18 AND TIMESTAMPDIFF(YEAR,ngay_sinh,NOW()) <50 AND dia_chi REGEXP('(Quảng trị|Đà Nẵng)');


-- Task 4 CÂU 4--  
-- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”
SELECT 
    khach_hang.ho_ten,
    khach_hang.ma_khach_hang,
    COUNT(khach_hang.ma_khach_hang) AS so_lan_dat_phong
FROM
    khach_hang
        JOIN
    hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
WHERE
    khach_hang.ma_loai_khach = 1
GROUP BY (khach_hang.ma_khach_hang)
ORDER BY so_lan_dat_phong;

-- Task 4 CÂU 5 -- 
-- Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong,
-- ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau:
--  Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng.
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
SELECT 
    khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    loai_khach.ten_loai_khach,
    hop_dong.ma_hop_dong,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    dich_vu.ten_dich_vu,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    dich_vu_di_kem.gia,
    IFNULL(dich_vu.chi_phi_thue, 0) + SUM(IFNULL(dich_vu_di_kem.gia, 0) * IFNULL(hop_dong_chi_tiet.so_luong, 0)) AS tong_tien
FROM
    khach_hang
        LEFT JOIN
    loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
        LEFT JOIN
    hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
        LEFT JOIN
    dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY ma_hop_dong , ma_khach_hang;
    
-- Task 5 CÂU 6 -- 
--  Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue,
-- ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
SELECT 
    dich_vu.ma_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu,
    hop_dong.ngay_lam_hop_dong
FROM
    dich_vu
        LEFT JOIN
    loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
        JOIN
    hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
WHERE
    dich_vu.ma_dich_vu NOT IN (SELECT 
            ma_dich_vu
        FROM
            hop_dong
        WHERE
            MONTH(ngay_lam_hop_dong) IN (1 , 2, 3)
                AND YEAR(ngay_lam_hop_dong) = '2021')
GROUP BY dich_vu.ma_dich_vu
ORDER BY ten_dich_vu DESC;
       
-- Task 5 CÂU7--
-- Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
SELECT 
    dich_vu.ma_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu,
    hop_dong.ngay_lam_hop_dong,
    dich_vu.so_nguoi_toi_da
FROM
    dich_vu
        LEFT JOIN
    loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
        JOIN
    hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) = '2020'
        AND dich_vu.ma_dich_vu NOT IN (SELECT 
            ma_dich_vu
        FROM
            hop_dong
        WHERE
            YEAR(ngay_lam_hop_dong) = '2021')
GROUP BY dich_vu.ma_dich_vu
ORDER BY ten_dich_vu DESC;

-- Task 5 CÂU 8 --
-- Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau. (3 cách)
SELECT DISTINCT  khach_hang.ho_ten FROM khach_hang;
SELECT khach_hang.ho_ten FROM khach_hang
GROUP BY khach_hang.ho_ten;
SELECT khach_hang.ho_ten FROM khach_hang
UNION
SELECT khach_hang.ho_ten FROM khach_hang;

-- Task 5 CÂU 9 --
-- Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng. 
SELECT 
    MONTH(ngay_lam_hop_dong) AS `month`,
    COUNT(MONTH(ngay_lam_hop_dong)) AS so_luong_khach_hang
FROM
    hop_dong
WHERE
    YEAR(ngay_lam_hop_dong) = '2021'
GROUP BY `month`
ORDER BY `month`;

-- Task 5 CÂU 10 --
-- Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm.
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc,
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở hop_dong_chi_tiet).
SELECT 
    hop_dong.ma_hop_dong,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    hop_dong.tien_dat_coc,
    SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0)) AS so_luong_dich_vu_di_kem
FROM
    hop_dong
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY hop_dong.ma_hop_dong;

-- Task 6 CÂU 11 --
-- Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” 
-- và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
SELECT 
    dich_vu_di_kem.*,
    khach_hang.ho_ten,
    loai_khach.ten_loai_khach,
    khach_hang.dia_chi
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
        JOIN
    hop_dong ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        JOIN
    khach_hang ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
        JOIN
    loai_khach ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
WHERE
    khach_hang.ma_loai_khach = 1
        AND khach_hang.dia_chi REGEXP ('(Vinh|Quảng Ngãi)');

-- Task 6 CÂU 12 --
-- Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), 
-- ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở hop_dong_chi_tiet),
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
SELECT 
    hop_dong.ma_hop_dong,
    khach_hang.ho_ten,
    nhan_vien.ho_ten,
    khach_hang.so_dien_thoai,
    dich_vu.ten_dich_vu,
    hop_dong.tien_dat_coc,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    hop_dong.ngay_lam_hop_dong,
    SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0)) AS so_luong_dich_vu_di_kem
FROM
    dich_vu
        JOIN
    hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        LEFT JOIN
    khach_hang ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
        LEFT JOIN
    nhan_vien ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) = '2020'
        AND MONTH(hop_dong.ngay_lam_hop_dong) IN (10 , 11, 12)
        AND dich_vu.ma_dich_vu NOT IN (SELECT 
            ma_dich_vu
        FROM
            hop_dong
        WHERE
            MONTH(ngay_lam_hop_dong) IN (1 , 2, 3, 4, 5, 6)
                AND YEAR(ngay_lam_hop_dong) = '2021')
GROUP BY ma_hop_dong;

-- Task 6 CÂU 13 --
-- Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,
    hop_dong_chi_tiet.ma_hop_dong_chi_tiet,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0)) AS so_luong_dich_vu_di_kem
FROM
    hop_dong_chi_tiet
        JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY dich_vu_di_kem.ten_dich_vu_di_kem
HAVING SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0)) >= ALL (SELECT 
        #SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0))
        MAX(hop_dong_chi_tiet.so_luong)
    FROM
        hop_dong_chi_tiet
    GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem);
  
  -- Task 6 CÂU 14 --
#Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
#Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    hop_dong_chi_tiet.ma_hop_dong,
    loai_dich_vu.ten_loai_dich_vu,
    COUNT(hop_dong_chi_tiet.ma_dich_vu_di_kem) AS so_lan_su_dung
FROM
    dich_vu
        JOIN
    loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
        JOIN
    hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem
HAVING so_lan_su_dung = 1;

  -- Task 6 CÂU 15 --
  #Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan,
  #so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
SELECT 
    nhan_vien.ma_nhan_vien,
    nhan_vien.ho_ten,
    trinh_do.ten_trinh_do,
    bo_phan.ten_bo_phan,
    nhan_vien.so_dien_thoai,
    nhan_vien.dia_chi
FROM
    nhan_vien
        JOIN
    vi_tri ON nhan_vien.ma_vi_tri = vi_tri.ma_vi_tri
        JOIN
    trinh_do ON nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
        JOIN
    bo_phan ON nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
        JOIN
    hop_dong ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) IN (2020 , 2021)
GROUP BY hop_dong.ma_nhan_vien
HAVING COUNT(hop_dong.ma_nhan_vien) <= 3;

-- Task 7 CÂU 16 --
#Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.	
SET SQL_SAFE_UPDATES = 0;
DELETE FROM nhan_vien 
WHERE
    nhan_vien.ma_nhan_vien NOT IN (SELECT 
        *
    FROM
        (SELECT 
            nhan_vien.ma_nhan_vien
        FROM
            nhan_vien
        LEFT JOIN hop_dong ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
        
        WHERE
            hop_dong.ngay_lam_hop_dong BETWEEN '2019-01-01' AND '2021-12-31') AS x);
SELECT * FROM nhan_vien;
SET SQL_SAFE_UPDATES = 1;

-- SET SQL_SAFE_UPDATES = 0;
-- DELETE FROM nhan_vien
-- WHERE ma_nhan_vien NOT IN (
-- SELECT hd.ma_nhan_vien
-- FROM hop_dong hd
-- GROUP BY hd.ma_nhan_vien
-- );
-- SET SQL_SAFE_UPDATES = 1;
-- SELECT * FROM nhan_vien;

-- Task 7 CÂU 17 --
# Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond,
# chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
# Tổng Tiền thanh toán = Chi Phí Thuê + Số Lượng * Giá

CREATE VIEW w_abc AS
    (SELECT 
        mkh, ht, SUM(view_table.tong_tien) AS tong_chi_phi
    FROM
        (SELECT 
            khach_hang.ma_khach_hang mkh,
                khach_hang.ho_ten ht,
                IFNULL(dich_vu.chi_phi_thue, 0) + SUM(IFNULL(dich_vu_di_kem.gia, 0) * IFNULL(hop_dong_chi_tiet.so_luong, 0)) AS tong_tien
        FROM
            khach_hang
        JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
        JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
        LEFT JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        LEFT JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        LEFT JOIN dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
        WHERE
            loai_khach.ten_loai_khach REGEXP ('Platinium')
                AND YEAR(hop_dong.ngay_lam_hop_dong) = 2021
        GROUP BY hop_dong.ma_hop_dong , khach_hang.ma_loai_khach
        HAVING tong_tien > 1000000) AS view_table
    GROUP BY mkh);
SET SQL_SAFE_UPDATES = 0;
UPDATE khach_hang 
SET 
    khach_hang.ma_loai_khach = 1
WHERE
    khach_hang.ma_khach_hang IN (SELECT 
            *
        FROM
            (SELECT mkh FROM w_abc) AS w);
SELECT * FROM khach_hang;
SET SQL_SAFE_UPDATES = 1;
SELECT mkh FROM w_abc;

-- Task 7 CÂU 18 --
# Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM khach_hang 
WHERE
    khach_hang.ma_khach_hang IN (SELECT 
        *
    FROM
        (SELECT 
            khach_hang.ma_khach_hang
        FROM
            khach_hang
        JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
        WHERE
            YEAR(hop_dong.ngay_lam_hop_dong) <2021) AS u);
SELECT * FROM nhan_vien;
SET SQL_SAFE_UPDATES = 1;

-- Task 7 CÂU 19 --
#Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
SET SQL_SAFE_UPDATES = 0;
SELECT * FROM dich_vu_di_kem;
UPDATE dich_vu_di_kem 
SET 
    dich_vu_di_kem.gia = dich_vu_di_kem.gia * 2
WHERE
    dich_vu_di_kem.ma_dich_vu_di_kem IN (SELECT 
            tb_view.ma_dich_vu_di_kem
        FROM
            (SELECT 
                hop_dong_chi_tiet.ma_hop_dong,
				dich_vu_di_kem.ten_dich_vu_di_kem,
				hop_dong_chi_tiet.so_luong,
				dich_vu_di_kem.gia,
				hop_dong.ngay_lam_hop_dong,
				dich_vu_di_kem.ma_dich_vu_di_kem,
				SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0)) AS tsl
            FROM
                dich_vu_di_kem
            JOIN hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
            JOIN hop_dong ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
            WHERE
                YEAR(hop_dong.ngay_lam_hop_dong) = 2020
            GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem
            HAVING tsl > 10) AS tb_view);
SELECT 
    *
FROM
    dich_vu_di_kem;
SET SQL_SAFE_UPDATES = 1;

-- Task 8 CÂU 20 --
#Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống,
#thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang),
#ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
SELECT nhan_vien.ho_ten,nhan_vien.email,nhan_vien.so_dien_thoai,nhan_vien.ngay_sinh,nhan_vien.dia_chi FROM nhan_vien 
UNION
SELECT khach_hang.ho_ten,khach_hang.email,khach_hang.so_dien_thoai,khach_hang.ngay_sinh,khach_hang.dia_chi FROM khach_hang;

-- Task 8 CÂU 21 --
#Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Gia Lai” 
#Và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “2020-11-19”.
CREATE VIEW v_nhan_vien AS
    (SELECT 
        nhan_vien.*, hop_dong.ngay_lam_hop_dong
    FROM
        nhan_vien
            JOIN
        hop_dong ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
    WHERE
        nhan_vien.dia_chi REGEXP ('Gia Lai')
            AND hop_dong.ngay_lam_hop_dong = "2020-11-19");
         
-- Task 8 CÂU 22 --
#Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Việt Nam” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
SET SQL_SAFE_UPDATES = 0;
UPDATE nhan_vien
SET nhan_vien.dia_chi="Việt Nam"
WHERE nhan_vien.ma_nhan_vien in (
SELECT * FROM (
SELECT ma_nhan_vien FROM v_nhan_vien) AS set_dia_chi);
SET SQL_SAFE_UPDATES = 1;
SELECT * FROM nhan_vien; 

-- Task 8 CÂU 23 --
#Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang. 
SET FOREIGN_KEY_CHECKS = 0; 
delimiter //
CREATE PROCEDURE sp_xoa_khach_hang(IN sp_mkh INT)
BEGIN
DELETE FROM khach_hang WHERE khach_hang.ma_khach_hang = sp_mkh;
END //
delimiter ;
 CALL sp_xoa_khach_hang(4);
 SET FOREIGN_KEY_CHECKS = 1; 

-- Task 8 CÂU 24 --
#Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong
#với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung,
#với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
delimiter //
CREATE PROCEDURE sp_them_moi_hop_dong(in sp_ngay_lam_hop_dong DATETIME,
sp_ngay_ket_thuc DATETIME,
sp_tien_dat_coc DOUBLE,
sp_ma_nhan_vien INT,
sp_ma_khach_hang INT,
sp_ma_dich_vu INT)
BEGIN
 INSERT INTO hop_dong(ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu) 
 VALUE (sp_ngay_lam_hop_dong,sp_ngay_ket_thuc,sp_tien_dat_coc,sp_ma_nhan_vien,sp_ma_khach_hang,sp_ma_dich_vu);
END//
DELIMITER ;
CALL sp_them_moi_hop_dong('2021-05-29','2021-06-11',0,7,9,1);
SELECT * FROM hop_dong;

#=======================Task 8 CÂU 25=================================#
#Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong 
#thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
CREATE TABLE so_luong_ban_ghi(
so_luong_ban_ghi INT,
-- tong_id INT,
delete_day DATETIME DEFAULT NOW()); 
DELIMITER //
CREATE TRIGGER xoa_hop_dong
AFTER DELETE ON hop_dong
FOR EACH ROW
BEGIN
INSERT INTO so_luong_ban_ghi(so_luong_ban_ghi)
SELECT COUNT(*) FROM hop_dong;
-- INSERT INTO so_luong_ban_ghi(tong_id)
-- SELECT SUM(ma_hop_dong) FROM hop_dong;
END//
DELIMITER ;
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM hop_dong 
WHERE
    hop_dong.ma_hop_dong = 1;
DELETE FROM hop_dong 
WHERE
    hop_dong.ma_hop_dong = 2;
SELECT 
    *
FROM
    so_luong_ban_ghi;
DROP TRIGGER xoa_hop_dong;
#======================== Task 8 CÂU 26=====================#
#==Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, 
#==với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày.
#==Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
DELIMITER //
CREATE TRIGGER tr_cap_nhat_hop_dong
BEFORE UPDATE ON hop_dong
FOR EACH ROW
BEGIN
DECLARE error_message VARCHAR(225);
IF datediff(NEW.ngay_ket_thuc,OLD.ngay_lam_hop_dong) <2 THEN
SET error_message="Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày";
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = error_message;
END IF;
END//
DELIMITER ;
SET SQL_SAFE_UPDATES = 0;
UPDATE hop_dong
SET ngay_ket_thuc ="20210319"
WHERE ma_hop_dong= 3;
UPDATE hop_dong
SET ngay_ket_thuc ="20210316"
WHERE ma_hop_dong= 3;
DROP TRIGGER tr_cap_nhat_hop_dong;

