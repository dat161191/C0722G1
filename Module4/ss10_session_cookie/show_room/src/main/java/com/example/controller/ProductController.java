package com.example.controller;


import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping("/shop")
    public String showShop(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") Long id, @PageableDefault(page = 0, size = 3) Pageable pageable) {
        Page<Product> productList = productService.findAll(pageable);
        model.addAttribute("productList", productList);
        if (id != -1) {
            model.addAttribute("historyProduct", productService.findById(id).get());
        }
        return "/product/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") Long id, Model model, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", String.valueOf(id));
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);

        Optional<Product> product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(), productDto);
        model.addAttribute("product", productDto);
        return "/product/detail";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long id, @SessionAttribute("cart") CartDto cartDto, @RequestParam("action") String action, RedirectAttributes redirectAttributes) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error";
        }
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(), productDto);
        if (action.equals("cart")) {
            cartDto.addProduct(productDto);
            return "redirect:/cart";
        }
        else if (action.equals("detail")) {
            cartDto.addProduct(productDto);
            redirectAttributes.addFlashAttribute("mess", "Add success");
            return "redirect:/detail/{id}";
        } else {
            cartDto.addProduct(productDto);
            redirectAttributes.addFlashAttribute("mess", "Add success");
            return "redirect:/shop";
        }
    }

    @GetMapping("/sub/{id}")
    public String subToCart(@PathVariable("id") Long id, @SessionAttribute("cart") CartDto cartDto, @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error";
        }
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(), productDto);
        if (action.equals("cart")) {
            cartDto.subProduct(productDto);
            return "redirect:/cart";
        } else {
            cartDto.subProduct(productDto);
            return "redirect:/shop";
        }
    }
}
