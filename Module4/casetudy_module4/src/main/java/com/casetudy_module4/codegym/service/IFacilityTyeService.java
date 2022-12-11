package com.casetudy_module4.codegym.service;

import com.casetudy_module4.codegym.model.customer.CustomerType;
import com.casetudy_module4.codegym.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTyeService {
    List<FacilityType> findAll();

    FacilityType findById(Integer id);

    void save(FacilityType facilityType);

    void remove(Integer id);
}
