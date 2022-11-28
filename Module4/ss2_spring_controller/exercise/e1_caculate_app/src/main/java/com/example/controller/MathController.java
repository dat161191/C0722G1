package com.example.controller;

import com.example.service.IMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MathController {
    @Autowired
    IMathService mathService;

    @GetMapping("")
    public String showList() {
        return "list";
    }
    @PostMapping("math")
    public String mathController(@RequestParam double num1,@RequestParam double num2,@RequestParam String math, Model model){
    double result=mathService.Result(num1,num2,math);
    model.addAttribute("result",result);
    return "list";
    }
}
