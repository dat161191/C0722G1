package com.casetudy_module4.codegym.service.impl_facility;

import com.casetudy_module4.codegym.dto.facility_dto.FacilityDto;
import com.casetudy_module4.codegym.model.facility.Facility;
import com.casetudy_module4.codegym.model.facility.FacilityType;
import com.casetudy_module4.codegym.repository.facility.IFacilityRepository;
import com.casetudy_module4.codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findByNameContainingAndFacilityTypeOrderByName(String name, FacilityType facilityType, Pageable pageable) {
        return facilityRepository.findByNameContainingAndFacilityTypeOrderByName(name, facilityType, pageable);
    }

    @Override
    public Page<Facility> findByNameContainingOrderByName(String name, Pageable pageable) {
        return facilityRepository.findByNameContainingOrderByName(name,pageable);
    }

    @Override
    public Facility findById(Integer id) {
        return facilityRepository.findById(id).get();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(Integer id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }
}
