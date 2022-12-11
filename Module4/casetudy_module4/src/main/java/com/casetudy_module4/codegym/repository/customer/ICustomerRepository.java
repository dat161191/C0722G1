package com.casetudy_module4.codegym.repository.customer;

import com.casetudy_module4.codegym.dto.customer_dto.CustomerDto;
import com.casetudy_module4.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT c.* FROM customer c WHERE c.deleted = false ", countQuery = "SELECT c.* FROM customer c WHERE c.deleted = false", nativeQuery = true)
    Page<CustomerDto> showList(Pageable pageable);

    @Query(value = "select * from customer as c where c.deleted =false and (c.name like concat('%',:name,'%') and c.email like concat('%',:email,'%') and c.customer_type_id like concat ('%',:customerTypeId,'%') )"
            , countQuery = "select * from customer as c where c.deleted =false and (c.name like concat('%',:name,'%') and c.email like concat('%',:email,'%') and c.customer_type_id like concat ('%',:customerTypeId,'%') )"
            , nativeQuery = true)
    Page<Customer> showListAndSearch(@Param("name") String name, @Param("email") String email, @Param("customerTypeId") String customerTypeId, Pageable pageable);

    Page<CustomerDto> findByDeleted(Pageable pageable, boolean delete);
}

