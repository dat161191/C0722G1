package com.example.service.impl;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService implements ICustomerService {
    private static final Map<Integer, Customer> customers;

    static {

        customers = new HashMap<>();
        customers.put(1, new Customer((int) (Math.random() * 10000), "John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Customer((int) (Math.random() * 10000), "Bill", "bill@codegym.vn", "Danang"));
        customers.put(3, new Customer((int) (Math.random() * 10000), "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4, new Customer((int) (Math.random() * 10000), "Adam", "adam@codegym.vn", "Beijin"));
        customers.put(5, new Customer((int) (Math.random() * 10000), "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6, new Customer((int) (Math.random() * 10000), "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        List<Customer> customerList=new ArrayList<>(customers.values());
        for (Customer customer:customerList){
            if(customer.getId()==id){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
