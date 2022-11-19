package com.example.service.impl;

import com.example.service.IMathService;
import org.springframework.stereotype.Service;

@Service
public class MathService implements IMathService {
    @Override
    public double Result(double num1, double num2, String math) {
        double result;
        switch (math) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            default:
                result = num1 / num2;
                break;
        }
        return result;
    }
}
