package com.example.controller;

import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("cart") //B1:Khai báo session
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    /*==B2: lấy idproduct từ cookie==*/
    public String showList(@CookieValue(value = "idProduct",defaultValue = "-1") long idProduct, @PageableDefault(page=0,size=3) Pageable pageable, Model model){
        model.addAttribute("productList",productService.findAll(pageable));
        if (idProduct!= -1){
            model.addAttribute("detaiProduct",productService.findById(idProduct));
        }
        return "/list";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model,@PathVariable long id, HttpServletResponse httpServletResponse){
        /*==Chuyển đổi KDL id từ long sang String đối vs Cookie==*/
        Cookie cookie=new Cookie("idProduct",String.valueOf(id));
        cookie.setMaxAge(60*2);
        cookie.setPath("/");

        /*== B1:đưa cookie xuống clinet==*/
        httpServletResponse.addCookie(cookie);

        model.addAttribute("product",productService.findById(id));
        return "/detail";
    }
    /*==B2:Khởi tạo giá trị ban đầu cho 1 Session==*/
    @ModelAttribute("cart")
    public CartDto initCart(){return new CartDto();} //Tao 1 gio hang rong~
    @GetMapping("/add/{id}")
    /*==B3:cập nhật cart*/
    public String addToCart(@PathVariable Long id,@SessionAttribute("cart") CartDto cartDto){
        Product product=productService.findById(id);
        ProductDto productDto=new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        cartDto.addProduct(productDto);
        return "redirect:/cart";
    }

}
