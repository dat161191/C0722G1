package com.casetudy_module4.codegym.controller;

import com.casetudy_module4.codegym.model.User.Role;
import com.casetudy_module4.codegym.model.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
    @GetMapping("")
    public String home(@ModelAttribute User user, @ModelAttribute Role role, Model model){
        model.addAttribute("user",new User());
        model.addAttribute("role",new Role());
        return "/index";
    }
    @GetMapping("/login")
//    public String login(@ModelAttribute User user, @ModelAttribute Role role, Model model) {
//        model.addAttribute("user",new User());
//        model.addAttribute("role",new Role());
//        return "login";
//    }

    public String login() {
        return "login";
    }
}
