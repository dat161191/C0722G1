package com.casetudy_module4.codegym.dto.employee_dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
@Builder
@AllArgsConstructor
@Getter

public class EmployeeDtoList {
    private Long id;
    private String name;
    private String dateOfBirth;
    private String address;
}
