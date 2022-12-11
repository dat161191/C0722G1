package com.casetudy_module4.codegym.repository.facility;

import com.casetudy_module4.codegym.dto.facility_dto.FacilityDto;
import com.casetudy_module4.codegym.model.facility.Facility;
import com.casetudy_module4.codegym.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findByNameContainingAndFacilityTypeOrderByName(String name, FacilityType facilityType, Pageable pageable);

    Page<Facility> findByNameContainingOrderByName(String name, Pageable pageable);

}
