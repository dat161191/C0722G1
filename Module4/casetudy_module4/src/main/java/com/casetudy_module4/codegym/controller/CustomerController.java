package com.casetudy_module4.codegym.controller;

import com.casetudy_module4.codegym.dto.customer_dto.CustomerDto;
import com.casetudy_module4.codegym.model.customer.Customer;
import com.casetudy_module4.codegym.model.customer.CustomerType;
import com.casetudy_module4.codegym.service.ICustomerService;
import com.casetudy_module4.codegym.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String showList(@PageableDefault(page = 0, size = 4) Pageable pageable, Model model) {
        CustomerType customerType = new CustomerType();
        Page<CustomerDto> customers = customerService.showList(pageable);
        model.addAttribute("customerType",customerType);
        model.addAttribute("customerList",customers);

        return "/customer/list";
    }
}
