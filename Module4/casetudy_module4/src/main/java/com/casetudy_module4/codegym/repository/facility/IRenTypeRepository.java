package com.casetudy_module4.codegym.repository.facility;

import com.casetudy_module4.codegym.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRenTypeRepository extends JpaRepository<RentType,Integer> {
}
