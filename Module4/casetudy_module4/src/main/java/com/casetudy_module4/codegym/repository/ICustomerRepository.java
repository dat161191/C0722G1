package com.casetudy_module4.codegym.repository;

import com.casetudy_module4.codegym.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}
