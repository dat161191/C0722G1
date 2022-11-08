package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAllCustomer();
    boolean addCustomer(Customer customer);
    boolean removeCustomer(int id);
    boolean editCustomer(Customer customer);
    Customer findByID(int id);

}
