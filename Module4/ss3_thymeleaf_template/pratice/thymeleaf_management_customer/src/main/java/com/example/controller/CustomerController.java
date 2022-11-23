package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "index";
    }
    /*==========ADD NEW CUSTOMER===========*/
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("/save")
    public String save(Customer customer,RedirectAttributes redirect) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Add Success");
        return "redirect:/";
    }
    /*=========== EDIT CUSTOMER===========*/
    @GetMapping("/edit")
    public String edit(int id, Model model) {
        List<Customer> customerList = customerService.findAll();
        Customer customer= customerService.findById(id);
        model.addAttribute("customer",customer);
        return "edit";
    }
    @PostMapping("/update")
    public String update(Customer customer,RedirectAttributes redirect) {
        customerService.update(customer.getId(), customer);
        redirect.addFlashAttribute("message", "Edit Success");
        redirect.addFlashAttribute("customer",customer);
        return "redirect:/";
    }
}
