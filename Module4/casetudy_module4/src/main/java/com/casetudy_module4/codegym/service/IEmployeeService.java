package com.casetudy_module4.codegym.service;

import com.casetudy_module4.codegym.dto.employee_dto.EmployeeDtoList;
import com.casetudy_module4.codegym.model.employee.Employee;
import com.casetudy_module4.codegym.model.facility.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<EmployeeDtoList> findByDeleted(Pageable pageable);
    public List<Employee> findAll();
}
