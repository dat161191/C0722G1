package com.example.controller;

import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")

public class ConvertController {
    @Autowired
    private IConvertService convertService;

    @RequestMapping("")
    public String convert() {
        return "convert";
    }

    @RequestMapping(value = "/convert_to_usd",method = RequestMethod.POST)
    public String convertToUSD(double vnd, Model model) {
        double result = convertService.toUsd(vnd);
        model.addAttribute("result", result + " $");
        return "convert";
    }

    @RequestMapping(value = "/convert_to_vnd",method = RequestMethod.POST)
    public String convertToVND(double usd, Model model) {
        double result = convertService.toVnd(usd);
        model.addAttribute("result", result + " VND");
        return "convert";
    }
}
