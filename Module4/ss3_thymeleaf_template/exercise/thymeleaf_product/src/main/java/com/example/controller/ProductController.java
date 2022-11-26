package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
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
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirect) {
        iProductService.addProduct(product);
        redirect.addFlashAttribute("message", "Add Success");

        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@ModelAttribute("id") int id, Model model) {
        Product product = iProductService.findProductById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirect) {
        iProductService.updateProduct(product);
        redirect.addFlashAttribute("message", "Edit Success");
        redirect.addFlashAttribute("product", product);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int deleteConfirm, RedirectAttributes redirectAttributes) {
        Product product = iProductService.findProductById(deleteConfirm);
        iProductService.removeProduct(product);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@RequestParam String search, Model model) {
        model.addAttribute("productList", iProductService.searchByName(search));
        model.addAttribute("search", search);
        return "home";
    }

    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductService.findProductById(id));
        return "view";
    }
}
