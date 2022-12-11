package com.casetudy_module4.codegym.repository.employee;

import com.casetudy_module4.codegym.dto.employee_dto.EmployeeDtoList;
import com.casetudy_module4.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    Page<EmployeeDtoList> findByDeleted(Pageable pageable, boolean delete);
}
