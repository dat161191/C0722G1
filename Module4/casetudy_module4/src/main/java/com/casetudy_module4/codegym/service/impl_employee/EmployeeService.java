package com.casetudy_module4.codegym.service.impl_employee;

import com.casetudy_module4.codegym.dto.employee_dto.EmployeeDtoList;
import com.casetudy_module4.codegym.model.employee.Employee;
import com.casetudy_module4.codegym.repository.employee.IEmployeeRepository;
import com.casetudy_module4.codegym.service.IEmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Page<EmployeeDtoList> findByDeleted(Pageable pageable) {
        return employeeRepository.findByDeleted(pageable,false);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
