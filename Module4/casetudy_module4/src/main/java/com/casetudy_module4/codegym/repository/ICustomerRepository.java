package com.casetudy_module4.codegym.repository;

import com.casetudy_module4.codegym.dto.customer_dto.CustomerDto;
import com.casetudy_module4.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT c.* FROM customer c WHERE c.deleted = false ",countQuery = "SELECT c.* FROM customer c WHERE c.deleted = false",nativeQuery = true)
    Page<CustomerDto> showList(Pageable pageable);
    Page<CustomerDto> findByDeleted(Pageable pageable,boolean delete);

}

