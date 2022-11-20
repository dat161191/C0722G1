package com.example.service.impl;

import com.example.service.IMatchService;
import org.springframework.stereotype.Service;

@Service
public class MatchService implements IMatchService {
    @Override
    public double Match(double num1, double num2, String match) {
        double result;
        switch (match) {
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
