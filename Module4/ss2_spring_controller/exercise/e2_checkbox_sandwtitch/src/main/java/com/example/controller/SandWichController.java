package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandWichController {
    @GetMapping("")
    public String display(){
        return "index";
    }

    /*===REDIRECT===*/
//    @PostMapping("/save")
//    public String add(RedirectAttributes redirectAttributes, @RequestParam("giaVi") String[] list){
//        redirectAttributes.addFlashAttribute("list",list);
//        return "redirect:/";
//    }

    /*===FORWARD===*/
    @PostMapping("/save")
    public String add(@RequestParam("giaVi") String[] list,Model model){
        model.addAttribute("list",list);
        return "index";
    }
}
