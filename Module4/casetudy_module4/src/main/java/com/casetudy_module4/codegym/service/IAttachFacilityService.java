package com.casetudy_module4.codegym.service;

import com.casetudy_module4.codegym.dto.contact_dto.AttachFacilityDto;
import com.casetudy_module4.codegym.model.contact.AttachFacility;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    AttachFacility findById(Long id);

    void save(AttachFacility attachFacility);

    void remove(Long id);
    List<AttachFacilityDto> showListAttach(@Param("id")Long id);
}
