package com.casetudy_module4.codegym.service.impl_facility;

import com.casetudy_module4.codegym.model.facility.RentType;
import com.casetudy_module4.codegym.repository.facility.IRenTypeRepository;
import com.casetudy_module4.codegym.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRenTypeRepository renTypeRepository;

    @Override
    public List<RentType> findAll() {
        return renTypeRepository.findAll();
    }

    @Override
    public RentType findById(Integer id) {
        return renTypeRepository.findById(id).get();
    }

    @Override
    public void save(RentType rentType) {
        renTypeRepository.save(rentType);
    }

    @Override
    public void remove(Integer id) {
        renTypeRepository.deleteById(id);
    }
}
