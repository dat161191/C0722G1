package com.example.service.impl;

import com.example.model.HinhThucThanhToan;
import com.example.repository.IHinhThucThanhToanRepository;
import com.example.service.IHinhThucThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HinhThucThanhToanSerVice implements IHinhThucThanhToanService {
    @Autowired
    private IHinhThucThanhToanRepository hinhThucThanhToanRepository;


    @Override
    public List<HinhThucThanhToan> findAll() {
        return hinhThucThanhToanRepository.findAll();
    }

    @Override
    public HinhThucThanhToan findById(Integer id) {
        return hinhThucThanhToanRepository.findById(id).get();
    }
}
