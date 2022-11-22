package com.example.controller;

import com.example.model.Login;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String index() {
        return "index";
    }

    //    @GetMapping("/home")
//    public ModelAndView home(){
//        ModelAndView modelAndView=new ModelAndView("home","login",new Login());
//        return modelAndView;
//    }
    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("login", new Login());
        return "home";
    }

    @PostMapping("/login")
//    public ModelAndView login(@ModelAttribute("login") Login login) {
//        User user = iUserService.checkLogin(login);
//        if (user == null) {
//            ModelAndView modelAndView = new ModelAndView("error");
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("user");
//            modelAndView.addObject("user", user);
//            return modelAndView;
//        }
//    }

    public String login(@ModelAttribute("login") Login login,Model model){
//    public String login(@RequestParam("login") Login login, Model model){
        User user = iUserService.checkLogin(login);
        if (user == null) {
            return "error";
        }else {
            model.addAttribute("user",user);
            return "user";
        }
    }
}