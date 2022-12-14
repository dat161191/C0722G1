package com.casetudy_module4.codegym.controller;

import com.casetudy_module4.codegym.dto.customer_dto.CustomerDto;
import com.casetudy_module4.codegym.model.customer.Customer;
import com.casetudy_module4.codegym.model.customer.CustomerType;
import com.casetudy_module4.codegym.service.ICustomerService;
import com.casetudy_module4.codegym.service.ICustomerTypeService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String home(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String customerTypeId, @PageableDefault(page = 0, size = 3) Pageable pageable, Model model) {
        CustomerType customerType1 = new CustomerType();
        CustomerDto customerDto = CustomerDto.builder().build();
        CustomerDto customerDtoEdit = CustomerDto.builder().build();
        Page<Customer> customerList = customerService.showListAndSearch(name, email, customerTypeId, pageable);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerType", customerType1);
        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerDtoEdit", customerDtoEdit);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        if (!customerTypeId.isEmpty()) {
            model.addAttribute("customerTypeId", Integer.parseInt(customerTypeId));
        }
        return "customer/list";
    }

    @GetMapping("delete")
    public String delete(@RequestParam Integer deleteId, @RequestParam("deleteName2") String deleteName2, RedirectAttributes redirectAttributes) {
        customerService.remove(deleteId);
        redirectAttributes.addFlashAttribute("deleteAlert", 1);
        redirectAttributes.addFlashAttribute("deleteName2", deleteName2);
        return "redirect:/customer/";
    }

    @PostMapping("create")
    public String create(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResultCreate, Model model,
                         RedirectAttributes redirectAttributes, @ModelAttribute("customerDtoEdit") CustomerDto customerDtoEdit) {
        Page<Customer> customerList = customerService.showListAndSearch("", "", "", PageRequest.of(0, 4));
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        CustomerType customerType1 = new CustomerType();
        if (bindingResultCreate.hasErrors()) {
            model.addAttribute("hasErrors", 2);
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerType", customerType1);
            model.addAttribute("customerList", customerList);
            model.addAttribute("customerTypeList", customerTypeList);
            return "customer/list";
        }
        Customer customer = Customer.builder().build();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("mess", "Add new Customer success!!!");
        redirectAttributes.addFlashAttribute("createAlert", 1);

        return "redirect:/customer";
    }

    @PostMapping("edit")
    public String edit(@Valid @ModelAttribute("customerDtoEdit") CustomerDto customerDtoEdit, BindingResult bindingResultEdit,
                       RedirectAttributes redirectAttributes, Model model, @ModelAttribute("customerDto") CustomerDto customerDto) {
        CustomerType customerType1 = new CustomerType();
        customerDto = CustomerDto.builder().build();

        Page<Customer> customerList = customerService.showListAndSearch("", "", "", PageRequest.of(0, 4));
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        if (bindingResultEdit.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("hasErrorsEdit", 1);
            model.addAttribute("customerDtoEdit", customerDtoEdit);
            model.addAttribute("customerType", customerType1);
            model.addAttribute("customerList", customerList);
            model.addAttribute("customerTypeList", customerTypeList);
            return "customer/list";

        }
        Customer customer = Customer.builder().build();
        BeanUtils.copyProperties(customerDtoEdit, customer);
        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("mess", "Edit Customer success!!!");
        redirectAttributes.addFlashAttribute("editAlert", 1);
        return "redirect:/customer";
    }
}
