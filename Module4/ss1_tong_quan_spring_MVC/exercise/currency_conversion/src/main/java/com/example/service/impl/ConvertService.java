package com.example.service.impl;

import com.example.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public double toUsd(double vnd) {
        return vnd / 23000;
    }

    @Override
    public double toVnd(double usd) {
        return usd * 23000;
    }
}
