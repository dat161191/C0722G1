package com.example.repository;

import com.example.model.HinhThucThanhToan;
import com.example.model.ThongTinThueTro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IThongTinThueTroRepository extends JpaRepository<ThongTinThueTro,Integer> {
    Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTroContainsAndHinhThucThanhToans(String tnt, String ngay, HinhThucThanhToan thanhToan, Pageable pageable);
//    Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTroAndHinhThucThanhToans(String tnt, String ngay, HinhThucThanhToan thanhToan, Pageable pageable);
//    Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTro(String tnt,String ngay,Pageable pageable);
    Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTroContains(String tnt,String ngay,Pageable pageable);
}
