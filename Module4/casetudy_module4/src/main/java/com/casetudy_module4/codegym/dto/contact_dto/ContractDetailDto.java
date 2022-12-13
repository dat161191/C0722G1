package com.casetudy_module4.codegym.dto.contact_dto;
import com.casetudy_module4.codegym.model.contact.AttachFacility;
import com.casetudy_module4.codegym.model.contact.Contract;
import lombok.*;



@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ContractDetailDto {
    private Long id;
    private AttachFacility attachFacility;
    private Contract contract;
    private int quantity;
}
