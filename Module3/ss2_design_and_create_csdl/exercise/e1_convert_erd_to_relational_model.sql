DROP DATABASE IF EXISTS business_manager;
CREATE DATABASE IF NOT EXISTS business_manager;
USE business_manager;

CREATE TABLE phieu_xuat (
so_phieu_xuat INT PRIMARY KEY AUTO_INCREMENT,
ngay_xuat DATE NOT NULL);

CREATE TABLE vat_tu (
ma_vat_tu INT PRIMARY KEY AUTO_INCREMENT,
ten_vat_tu VARCHAR(50));

CREATE TABLE phieu_nhap (
so_phieu_nhap INT PRIMARY KEY AUTO_INCREMENT,
ngay_nhap DATE NOT NULL);

CREATE TABLE nha_cung_cap (
ma_nha_cung_cap INT PRIMARY KEY AUTO_INCREMENT,
ten_nha_cung_cap VARCHAR(50) NOT NULL,
dia_chi  VARCHAR(50),
so_dien_thoai VARCHAR(50) UNIQUE);

CREATE TABLE don_dat_hang (
so_don_hang INT PRIMARY KEY AUTO_INCREMENT,
ngay_dat_hang DATE NOT NULL);

CREATE TABLE chi_tiet_phieu_xuat(
so_phieu_xuat INT,
ma_vat_tu INT,
don_gia_xuat DOUBLE NOT NULL,
so_luong_xuat INT NOT NULL,
PRIMARY KEY (so_phieu_xuat,ma_vat_tu),
CONSTRAINT fk_phieu_xuat FOREIGN KEY(so_phieu_xuat) REFERENCES phieu_xuat(so_phieu_xuat),
CONSTRAINT fk_vat_tu FOREIGN KEY(ma_vat_tu) REFERENCES vat_tu(ma_vat_tu));

CREATE TABLE chi_tiet_phieu_nhap(
so_phieu_nhap INT,
ma_vat_tu INT,
don_gia_nhap DOUBLE NOT NULL,
so_luong_nhap INT NOT NULL,
PRIMARY KEY (so_phieu_nhap,ma_vat_tu),
CONSTRAINT fk_phieu_nhap FOREIGN KEY(so_phieu_nhap) REFERENCES phieu_nhap(so_phieu_nhap),
CONSTRAINT fk_vat_tu1 FOREIGN KEY(ma_vat_tu) REFERENCES vat_tu(ma_vat_tu));

CREATE TABLE chi_tiet_don_dat_hang(
so_don_hang INT,
ma_vat_tu INT,
PRIMARY KEY (so_don_hang,ma_vat_tu),
CONSTRAINT fk_don_dat_hang FOREIGN KEY(so_don_hang) REFERENCES don_dat_hang(so_don_hang),
CONSTRAINT fk_vat_tu2 FOREIGN KEY(ma_vat_tu) REFERENCES vat_tu(ma_vat_tu));

CREATE TABLE cung_cap(
so_don_hang INT,
ma_nha_cung_cap INT,
PRIMARY KEY (so_don_hang,ma_nha_cung_cap),
CONSTRAINT fk_don_dat_hang1 FOREIGN KEY(so_don_hang) REFERENCES don_dat_hang(so_don_hang),
CONSTRAINT fk_nha_cung_cap FOREIGN KEY(ma_nha_cung_cap) REFERENCES nha_cung_cap(ma_nha_cung_cap));