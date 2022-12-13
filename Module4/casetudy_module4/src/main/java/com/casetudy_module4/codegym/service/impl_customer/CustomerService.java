package com.casetudy_module4.codegym.service.impl_customer;

import com.casetudy_module4.codegym.dto.customer_dto.CustomerDto;
import com.casetudy_module4.codegym.model.customer.Customer;
import com.casetudy_module4.codegym.repository.customer.ICustomerRepository;
import com.casetudy_module4.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<CustomerDto> findByDeleted(Pageable pageable) {
        return customerRepository.findByDeleted(pageable, false);
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

    @Override
    public Page<Customer> showListAndSearch(String name, String email, String customerTypeId, Pageable pageable) {
        return customerRepository.showListAndSearch(name, email, customerTypeId, pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
