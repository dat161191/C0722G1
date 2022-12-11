package com.casetudy_module4.codegym.service;

import com.casetudy_module4.codegym.model.customer.CustomerType;
import com.casetudy_module4.codegym.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();

    RentType findById(Integer id);

    void save(RentType rentType);

    void remove(Integer id);
}
