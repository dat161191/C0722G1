package com.example.service.impl;

import com.example.model.HinhThucThanhToan;
import com.example.model.ThongTinThueTro;
import com.example.repository.IThongTinThueTroRepository;
import com.example.service.IThongTinThueTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ThongTinPhongTroService implements IThongTinThueTroService {
    @Autowired
    private IThongTinThueTroRepository thongTinThueTroRepository;

    @Override
    public ThongTinThueTro findById(Integer id) {
        return thongTinThueTroRepository.findById(id).get();
    }

    @Override
    public void save(ThongTinThueTro thongTinThueTro) {
        thongTinThueTroRepository.save(thongTinThueTro);
    }

    @Override
    public void remove(Integer id) {
        thongTinThueTroRepository.deleteById(id);
    }

    @Override
//    public Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTro(String tnt, String ngay, Pageable pageable) {
    public Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTroContains(String tnt, String ngay, Pageable pageable) {
        return thongTinThueTroRepository.findByTenNguoiThueContainingAndNgayThueTroContains(tnt, ngay, pageable);
    }

    @Override
//    public Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTroAndHinhThucThanhToans(String tnt, String ngay, HinhThucThanhToan thanhToan, Pageable pageable) {
    public Page<ThongTinThueTro> findByTenNguoiThueContainingAndNgayThueTroContainsAndHinhThucThanhToans(String tnt, String ngay, HinhThucThanhToan thanhToan, Pageable pageable) {
//        return thongTinThueTroRepository.findByTenNguoiThueContainingAndNgayThueTroAndHinhThucThanhToans(tnt, ngay, thanhToan, pageable);
        return thongTinThueTroRepository.findByTenNguoiThueContainingAndNgayThueTroContainsAndHinhThucThanhToans(tnt, ngay, thanhToan, pageable);
    }
}
