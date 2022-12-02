package com.example.controller;

import com.example.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping()
    public String showCart(@SessionAttribute("cart")CartDto cart, Model model){//Su  dung cart
        model.addAttribute("cart",cart);
        return "/cart/list";
    }

    @GetMapping("/pay")
    public String pay(@SessionAttribute("cart") CartDto cartDto, RedirectAttributes redirectAttributes){
        cartDto.pay();
        redirectAttributes.addFlashAttribute("mess","Thanh toán thành công");
        return "redirect:/";
    }
}
