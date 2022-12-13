package com.casetudy_module4.codegym.repository.contract;

import com.casetudy_module4.codegym.model.contact.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
}
