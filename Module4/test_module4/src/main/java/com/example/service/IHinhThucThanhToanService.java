package com.example.service;

import com.example.model.HinhThucThanhToan;

import java.util.List;

public interface IHinhThucThanhToanService {
    List<HinhThucThanhToan> findAll();
    HinhThucThanhToan findById(Integer id);
}
