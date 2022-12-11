package com.casetudy_module4.codegym.service.impl_customer;

import com.casetudy_module4.codegym.model.customer.CustomerType;
import com.casetudy_module4.codegym.repository.customer.ICustomerTypeRepository;
import com.casetudy_module4.codegym.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Integer id) {
        return customerTypeRepository.findById(id).get();
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void remove(Integer id) {
        customerTypeRepository.deleteById(id);
    }
}
