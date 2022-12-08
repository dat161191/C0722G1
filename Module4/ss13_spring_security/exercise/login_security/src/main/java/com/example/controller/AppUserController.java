package com.example.controller;

import com.example.model.AppUser;
import com.example.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/user")
public class AppUserController {
    @Autowired
    private IAppUserService appUserService;

    @PostMapping("/user/create")
    public String create(@ModelAttribute AppUser user, RedirectAttributes redirectAttributes) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        appUserService.create(user);
        redirectAttributes.addFlashAttribute("mess", "Add new Account Success");
        return "redirect:/admin";
    }
}
