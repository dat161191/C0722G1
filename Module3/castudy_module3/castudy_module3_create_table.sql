DROP DATABASE IF EXISTS castudty_module3;
CREATE DATABASE IF NOT EXISTS castudty_module3;
USE castudty_module3;

-- Table vi_tri--  
CREATE TABLE vi_tri (
    ma_vi_tri INT PRIMARY KEY AUTO_INCREMENT,
    ten_vi_tri VARCHAR(45) NULL
);

-- Table trinh_do--
CREATE TABLE trinh_do (
    ma_trinh_do INT PRIMARY KEY AUTO_INCREMENT,
    ten_trinh_do VARCHAR(45) NULL
);

-- Table bo_phan-- 
CREATE TABLE bo_phan (
    ma_bo_phan INT PRIMARY KEY AUTO_INCREMENT,
    ten_bo_phan VARCHAR(45) NULL
);

-- Table nhan_vien-- 
CREATE TABLE nhan_vien (
    ma_nhan_vien INT PRIMARY KEY AUTO_INCREMENT,
    ho_ten VARCHAR(45) NOT NULL,
    ngay_sinh DATE NOT NULL,
    so_cmnd VARCHAR(45) NOT NULL UNIQUE,
    luong DOUBLE,
    so_dien_thoai VARCHAR(45) NOT NULL UNIQUE,
    email VARCHAR(45) UNIQUE,
    dia_chi VARCHAR(45) NOT NULL UNIQUE,
    ma_vi_tri INT NOT NULL,
    ma_trinh_do INT NOT NULL,
    ma_bo_phan INT NOT NULL,
    CONSTRAINT fk_vi_tri FOREIGN KEY (ma_vi_tri)
        REFERENCES vi_tri (ma_vi_tri),
    CONSTRAINT fk_trinh_do FOREIGN KEY (ma_vi_tri)
        REFERENCES trinh_do (ma_trinh_do),
    CONSTRAINT fk_bo_phan FOREIGN KEY (ma_bo_phan)
        REFERENCES bo_phan (ma_bo_phan)
);

-- Tabel loai_khach--  
CREATE TABLE loai_khach (
    ma_loai_khach INT PRIMARY KEY AUTO_INCREMENT,
    ten_loai_khach VARCHAR(45) NULL
);

-- Table khach_hang--  
CREATE TABLE khach_hang (
    ma_khach_hang INT PRIMARY KEY AUTO_INCREMENT,
    ma_loai_khach INT NOT NULL,
    ho_ten VARCHAR(45) NOT NULL,
    ngay_sinh DATE NOT NULL,
    gioi_tinh BIT(1),
    so_cmnd VARCHAR(45) NOT NULL UNIQUE,
    so_dien_thoai VARCHAR(45) NOT NULL UNIQUE,
    email VARCHAR(45) UNIQUE,
    dia_chi VARCHAR(45) NOT NULL UNIQUE,
    CONSTRAINT fk_loai_khach FOREIGN KEY (ma_loai_khach)
        REFERENCES loai_khach (ma_loai_khach)
);

-- Table loai_dich_vu--  
CREATE TABLE loai_dich_vu (
    ma_loai_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
    ten_loai_dich_vu VARCHAR(45) NULL
);

-- Table kieu_thue--  
CREATE TABLE kieu_thue (
    ma_kieu_thue INT PRIMARY KEY AUTO_INCREMENT,
    ten_kieu_thue VARCHAR(45) NULL
);

-- Table dich_vu--
CREATE TABLE dich_vu (ma_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
ten_dich_vu VARCHAR(45) NOT NULL,
dien_tich INT NOT NULL DEFAULT("0"),
chi_phi_thue DOUBLE NOT NULL,
so_nguoi_toi_da INT NOT NULL,
ma_kieu_thue INT NOT NULL,
ma_loai_dich_vu INT NOT NULL,
tieu_chuan_phong VARCHAR(45) NOT NULL,
mo_ta_tien_nghi_khac VARCHAR(45),
dien_tich_ho_boi DOUBLE DEFAULT("0"),
so_tang INT DEFAULT("0"),
dich_vu_mien_phi_di_kem TEXT,
CONSTRAINT fk_kieu_thue FOREIGN KEY (ma_kieu_thue) REFERENCES kieu_thue(ma_kieu_thue),
CONSTRAINT fk_loai_dich_vu FOREIGN KEY (ma_loai_dich_vu) REFERENCES loai_dich_vu(ma_loai_dich_vu));

-- Table hop_dong--  
CREATE TABLE hop_dong(
ma_hop_dong INT PRIMARY KEY AUTO_INCREMENT,
ngay_lam_hop_dong DATETIME NOT NULL,
ngay_ket_thuc DATETIME NOT NULL,
tien_dat_coc DOUBLE,
ma_nhan_vien INT NOT NULL,
ma_khach_hang INT NOT NULL,
ma_dich_vu INT NOT NULL,
CONSTRAINT fk_nhan_vien FOREIGN KEY (ma_nhan_vien) REFERENCES nhan_vien(ma_nhan_vien),
CONSTRAINT fk_khach_hang FOREIGN KEY (ma_khach_hang) REFERENCES khach_hang(ma_khach_hang),
CONSTRAINT fk_dich_vu FOREIGN KEY (ma_dich_vu) REFERENCES dich_vu(ma_dich_vu));

-- Table dich_vu_di_kem--   
CREATE TABLE dich_vu_di_kem(
ma_dich_vu_di_kem INT PRIMARY KEY AUTO_INCREMENT,
ten_dich_vu_di_kem VARCHAR(45) NOT NULL,
gia DOUBLE,
don_vi VARCHAR(10) DEFAULT("0"),
trang_thai VARCHAR(45) DEFAULT("..."));

-- Table hop_dong_di_kem--  
CREATE TABLE hop_dong_chi_tiet (
ma_hop_dong_chi_tiet INT PRIMARY KEY AUTO_INCREMENT,
ma_hop_dong INT NOT NULL,
ma_dich_vu_di_kem INT NOT NULL,
CONSTRAINT fk_dich_vu_di_kem FOREIGN KEY (ma_dich_vu_di_kem) REFERENCES dich_vu_di_kem(ma_dich_vu_di_kem),
CONSTRAINT fk_hop_dong FOREIGN KEY (ma_hop_dong) REFERENCES hop_dong(ma_hop_dong),
so_luong INT DEFAULT("0"));
