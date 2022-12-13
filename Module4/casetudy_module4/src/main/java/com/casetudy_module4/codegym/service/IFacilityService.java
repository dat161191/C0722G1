package com.casetudy_module4.codegym.service;

import com.casetudy_module4.codegym.model.facility.Facility;
import com.casetudy_module4.codegym.model.facility.FacilityType;
import com.casetudy_module4.codegym.model.facility.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findByNameContainingAndFacilityTypeOrderByName(String name, FacilityType facilityType, Pageable pageable);

    Page<Facility> findByNameContainingOrderByName(String name, Pageable pageable);

    Facility findById(Integer id);

    void save(Facility facility);

    void remove(Integer id);

    List<Facility> findAll();
}
