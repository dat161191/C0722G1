package com.casetudy_module4.codegym.controller;

import com.casetudy_module4.codegym.dto.employee_dto.EmployeeDtoList;
import com.casetudy_module4.codegym.service.IEmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public String showList(Model model, @PageableDefault(size = 4,page = 0) Pageable pageable){
        Page<EmployeeDtoList> employeeDtoLists=employeeService.findByDeleted(pageable);
        model.addAttribute("employeeDtoLists",employeeDtoLists);
        return "/employee/list";
    }
}
