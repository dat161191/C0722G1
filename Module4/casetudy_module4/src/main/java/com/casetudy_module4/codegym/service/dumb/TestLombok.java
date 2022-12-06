package com.casetudy_module4.codegym.service.dumb;

import com.casetudy_module4.codegym.model.employee.Employee;

public class TestLombok {
    public Employee initEmployee(){
        Employee employee = Employee.builder()
                .address("").build();
        return employee;
    }
}
