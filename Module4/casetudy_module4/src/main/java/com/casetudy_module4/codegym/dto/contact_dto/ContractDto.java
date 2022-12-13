package com.casetudy_module4.codegym.dto.contact_dto;
import com.casetudy_module4.codegym.model.customer.Customer;
import com.casetudy_module4.codegym.model.employee.Employee;
import com.casetudy_module4.codegym.model.facility.Facility;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ContractDto {
    private Long id;
    private String startDate;
    private String endDate;
    private double deposit;
    private Customer customer;
    private Employee employee;
    private Facility facility;
}
