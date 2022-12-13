package com.casetudy_module4.codegym.service;

import com.casetudy_module4.codegym.model.contact.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    AttachFacility findById(Long id);

    void save(AttachFacility attachFacility);

    void remove(Long id);
}
