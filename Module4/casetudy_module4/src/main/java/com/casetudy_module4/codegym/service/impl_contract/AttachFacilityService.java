package com.casetudy_module4.codegym.service.impl_contract;

import com.casetudy_module4.codegym.dto.contact_dto.AttachFacilityDto;
import com.casetudy_module4.codegym.model.contact.AttachFacility;
import com.casetudy_module4.codegym.repository.contract.IAttachFacilityRepository;
import com.casetudy_module4.codegym.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility findById(Long id) {
        return attachFacilityRepository.findById(id).get();
    }

    @Override
    public void save(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }

    @Override
    public void remove(Long id) {
        attachFacilityRepository.deleteById(id);
    }

    @Override
    public List<AttachFacilityDto> showListAttach(Long id) {
        return attachFacilityRepository.showListAttach(id);
    }
}
