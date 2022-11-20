package com.example.controller;

import com.example.service.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CaculateController {
    @Autowired
    IMatchService matchService;
    @GetMapping("")
    public String display(){
        return "index";
    }
    @PostMapping("match")
    public String mathController(double num1, double num2, String match, Model model){
        double result=matchService.Match(num1,num2,match);
        model.addAttribute("result",result);
        return "index";
    }
}
