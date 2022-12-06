package com.casetudy_module4.codegym.service;

import com.casetudy_module4.codegym.dto.employee_dto.EmployeeDtoList;
import com.casetudy_module4.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<EmployeeDtoList> findByDeleted(Pageable pageable);
}
