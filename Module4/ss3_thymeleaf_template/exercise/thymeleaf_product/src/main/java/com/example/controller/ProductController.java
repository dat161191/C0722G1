package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList", productList);
        return "home";
    }

    /*=========Add==========*/
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String save(Product product, RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 100));
        if (iProductService.addProduct(product)) {
            redirect.addFlashAttribute("message", "Add Success");
        } else {
            redirect.addFlashAttribute("message", "Add No Success");
        }
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(int id, Model model) {
        Product product = iProductService.findProductById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(Product product, RedirectAttributes redirect) {
        if (iProductService.updateProduct(product)) {
            redirect.addFlashAttribute("message", "Edit Success");
        } else {
            redirect.addFlashAttribute("message", "Edit No Success");
        }
        redirect.addFlashAttribute("product", product);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int deleteConfirm, RedirectAttributes redirectAttributes) {
        if (iProductService.removeProduct(deleteConfirm)) {
            redirectAttributes.addFlashAttribute("message", "Delete success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete no success");
        }
        return "redirect:/";
    }
    @PostMapping("/search")
    public String search(@RequestParam String search,Model model){
        Map<Integer,Product> mapSearch=iProductService.searchByName(search);
        List<Product> productList=new ArrayList<>(mapSearch.values());
        model.addAttribute("productList",productList);
        return "home";
    }
    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductService.findProductById(id));
        return "view";
    }
}
