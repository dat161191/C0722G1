package com.example.controller;

import com.example.dto.CartDto;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public String showList(@SessionAttribute("cart") CartDto cart, Model model, @CookieValue(value = "idProduct", defaultValue = "-1") Long id) {
        model.addAttribute("cart", cart);
        if (id != -1) {
            model.addAttribute("historyProduct", productService.findById(id).get());
        }
        return "/cart/list";
    }

    @PostMapping("/pay")
    public String pay(@SessionAttribute("cart") CartDto cartDto, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Pay success " + cartDto.countTotalPayment() + " Milion USD");
        cartDto.pay();
        return "redirect:/cart";
    }
}
