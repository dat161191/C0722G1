package com.e2_song_dto_validate.codegym.controller;

import com.e2_song_dto_validate.codegym.dto.UserDto;
import com.e2_song_dto_validate.codegym.model.User;
import com.e2_song_dto_validate.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public String display(Pageable pageable, Model model){
        Page<User> usersList = userService.findAll(pageable);
        model.addAttribute("usersList", usersList);
        return "/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "/create";
    }
    @PostMapping("/create")
    public String showCreateForm(@Validated @ModelAttribute("userDto")UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess", "User added successfully");
        return "redirect:/";
    }
}
