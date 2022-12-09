package com.casetudy_module4.codegym.service;

import com.casetudy_module4.codegym.dto.customer_dto.CustomerDto;
import com.casetudy_module4.codegym.model.customer.Customer;
import com.casetudy_module4.codegym.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<CustomerDto> findByDeleted(Pageable pageable);

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    Page<CustomerDto> showList(Pageable pageable);

    Page<Customer> showListAndSearch(String name, String email, String customerTypeId, Pageable pageable);
}
