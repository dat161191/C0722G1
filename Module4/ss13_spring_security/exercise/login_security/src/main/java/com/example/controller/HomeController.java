package com.example.controller;

import com.example.model.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
    @GetMapping("")
    public String home(@ModelAttribute AppUser appUser, Model model){
        model.addAttribute("user",new AppUser());
        return "/index";
    }

}
