package com.casetudy_module4.codegym.dto.customer_dto;

import com.casetudy_module4.codegym.model.contact.Contract;
import com.casetudy_module4.codegym.model.customer.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@FieldDefaults(makeFinal = true)
@Builder
@AllArgsConstructor
@Getter
public class CustomerDto implements Validator {
    private Integer id;
    @NotNull(message = "{NotNull}")
    private CustomerType customerType;
    @NotBlank(message = "{NotBlank}")
    @Pattern(regexp = "[A-za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]*", message = "{name}")
    private String name;
    @NotBlank(message = "{NotBlank}")
    private String dateOfBirth;
    @NotNull(message = "{NotNull}")
    private boolean gender;
    @NotBlank(message = "{NotBlank}")
    @Pattern(regexp = "^[0-9]{8,9}$", message = "{idCard}")
    private String idCard;
    @NotBlank(message = "{NotBlank}")
    @Pattern(regexp = "^[0][0-9]{8,9}$", message = "{phoneNumber}")
    private String phoneNumber;
    @NotBlank(message = "{NotBlank}")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "{email}")
    private String email;
    @NotBlank(message = "{NotBlank}")
//    @Pattern(regexp = "^[0-9]{1,3}[ ]\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "{address}")
    private String address;
    private Boolean deleted = false;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        if (!customerDto.isGender() == true || false) {
            errors.rejectValue("gender", "Gender", "Not in Gender!!!");
        }
    }
}
