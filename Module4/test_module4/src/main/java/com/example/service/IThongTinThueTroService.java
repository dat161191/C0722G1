package com.example.service;

import com.example.model.HinhThucThanhToan;
import com.example.model.ThongTinThueTro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IThongTinThueTroService {
    ThongTinThueTro findById(Integer id);

    void save(ThongTinThueTro thongTinThueTro);

    void remove(Integer id);
    Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTroContainsAndHinhThucThanhToans(String tnt, String ngay, HinhThucThanhToan thanhToan, Pageable pageable);
//    Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTroAndHinhThucThanhToans(String tnt, String ngay, HinhThucThanhToan thanhToan, Pageable pageable);
//    Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTro(String tnt,String ngay,Pageable pageable);
    Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTroContains(String tnt,String ngay,Pageable pageable);
}
