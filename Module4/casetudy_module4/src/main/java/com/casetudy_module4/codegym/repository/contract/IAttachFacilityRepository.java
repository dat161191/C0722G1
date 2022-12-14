package com.casetudy_module4.codegym.repository.contract;

import com.casetudy_module4.codegym.dto.contact_dto.AttachFacilityDto;
import com.casetudy_module4.codegym.model.contact.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Long> {
    @Query(value = "SELECT contract_detail.contract_id as contractId,attach_facility.name,attach_facility.cost,attach_facility.unit,attach_facility.status,contract_detail.quantity,(attach_facility.cost*contract_detail.quantity) as sumAttach FROM  contract_detail JOIN attach_facility ON attach_facility.id = contract_detail.attach_facility_id WHERE contract_detail.contract_id =:id",
    countQuery = "SELECT contract_detail.contract_id as contractId,attach_facility.name,attach_facility.cost,attach_facility.unit,attach_facility.status,contract_detail.quantity,(attach_facility.cost*contract_detail.quantity) as sumAttach FROM  contract_detail JOIN attach_facility ON attach_facility.id = contract_detail.attach_facility_id WHERE contract_detail.contract_id = :id",nativeQuery = true)
    List<AttachFacilityDto> showListAttach(@Param("id")Long id);
}
