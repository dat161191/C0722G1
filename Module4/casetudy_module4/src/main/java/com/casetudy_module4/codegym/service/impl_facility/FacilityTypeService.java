package com.casetudy_module4.codegym.service.impl_facility;

import com.casetudy_module4.codegym.model.facility.FacilityType;
import com.casetudy_module4.codegym.repository.facility.IFacilityTypeRepositoy;
import com.casetudy_module4.codegym.service.IFacilityTyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTyeService {
    @Autowired
    private IFacilityTypeRepositoy facilityTypeRepositoy;

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepositoy.findAll();
    }

    @Override
    public FacilityType findById(Integer id) {
        return facilityTypeRepositoy.findById(id).get();
    }

    @Override
    public void save(FacilityType facilityType) {
        facilityTypeRepositoy.save(facilityType);
    }

    @Override
    public void remove(Integer id) {
        facilityTypeRepositoy.deleteById(id);
    }
}
