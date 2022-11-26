package com.example.create_web_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @GetMapping("")
    public ModelAndView showGreeting(){
        return new ModelAndView("/greeting");
    }
}
