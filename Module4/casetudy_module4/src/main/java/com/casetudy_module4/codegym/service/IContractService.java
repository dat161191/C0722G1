package com.casetudy_module4.codegym.service;

import com.casetudy_module4.codegym.dto.contact_dto.ContractDtoList;
import com.casetudy_module4.codegym.model.contact.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<ContractDtoList> showListContract(Pageable pageable);

    Contract findById(Long id);

    void save(Contract contract);
}
