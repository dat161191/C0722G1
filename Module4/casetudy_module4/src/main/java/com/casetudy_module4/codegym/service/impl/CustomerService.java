package com.casetudy_module4.codegym.service.impl;

import com.casetudy_module4.codegym.dto.customer_dto.CustomerDto;
import com.casetudy_module4.codegym.model.customer.Customer;
import com.casetudy_module4.codegym.repository.ICustomerRepository;
import com.casetudy_module4.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<CustomerDto> findByDeleted(Pageable pageable) {
        return customerRepository.findByDeleted(pageable,false);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<CustomerDto> showList(Pageable pageable) {

        return customerRepository.showList(pageable);
    }
}
