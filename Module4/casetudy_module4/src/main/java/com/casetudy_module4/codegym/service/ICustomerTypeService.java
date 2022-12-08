package com.casetudy_module4.codegym.service;

import com.casetudy_module4.codegym.model.customer.CustomerType;


import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();

    CustomerType findById(Integer id);

    void save(CustomerType customerType);

    void remove(Integer id);
}
