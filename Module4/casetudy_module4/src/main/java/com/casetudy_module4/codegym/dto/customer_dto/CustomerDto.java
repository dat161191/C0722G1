package com.casetudy_module4.codegym.dto.customer_dto;

import com.casetudy_module4.codegym.model.contact.Contract;
import com.casetudy_module4.codegym.model.customer.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@FieldDefaults(makeFinal = true)
@Builder
@AllArgsConstructor
@Getter
public class CustomerDto {
    private Integer id;
    private CustomerType customerType;
    private String name;
    private String dateOfBirth;
    private boolean gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    private Boolean deleted = false;
    private Set<Contract> contracts;
}
