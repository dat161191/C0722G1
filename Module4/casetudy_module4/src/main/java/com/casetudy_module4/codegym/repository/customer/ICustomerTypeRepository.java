package com.casetudy_module4.codegym.repository.customer;

import com.casetudy_module4.codegym.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
}
