package com.casetudy_module4.codegym.dto.employee_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
@FieldDefaults(makeFinal = true)
@Builder
@AllArgsConstructor
@Getter
public class EmployeeDtoList {
    private Long id;
    private String name;
    private String dateOfBirth;

    private String idCard;

    private double salary;

    private String phoneNumber;

    private String email;

    private String address;
}
