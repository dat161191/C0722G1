package com.casetudy_module4.codegym.service.impl_contract;

import com.casetudy_module4.codegym.dto.contact_dto.ContractDtoList;
import com.casetudy_module4.codegym.model.contact.Contract;
import com.casetudy_module4.codegym.repository.contract.IContractRepository;
import com.casetudy_module4.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<ContractDtoList> showListContract(Pageable pageable) {
        return contractRepository.showListContract(pageable);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).get();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
