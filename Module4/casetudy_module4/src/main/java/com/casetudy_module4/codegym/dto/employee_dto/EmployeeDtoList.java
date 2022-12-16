package com.casetudy_module4.codegym.dto.employee_dto;

import com.casetudy_module4.codegym.model.employee.Division;
import com.casetudy_module4.codegym.model.employee.EducationDegree;
import com.casetudy_module4.codegym.model.employee.Position;
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

    private Position position;

    private EducationDegree educationDegree;

    private Division division;
}
