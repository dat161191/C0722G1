package com.example.controller;

import com.example.service.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculateController {
    @Autowired
    IMatchService matchService;
    @GetMapping("")
    public String display(){
        return "index";
    }
    @PostMapping("/match")
    public String mathController(@RequestParam double num1,@RequestParam double num2,@RequestParam String match, Model model){
        double result=matchService.Match(num1,num2,match);
        model.addAttribute("result",result);
        return "index";
    }
}
