package com.casetudy_module4.codegym.service;

import com.casetudy_module4.codegym.model.contact.ContractDetail;
import com.casetudy_module4.codegym.model.customer.CustomerType;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    ContractDetail findById(Long id);

    void save(ContractDetail contractDetail);

    void remove(Long id);
}
