package com.casetudy_module4.codegym.repository.contract;

import com.casetudy_module4.codegym.dto.contact_dto.ContractDtoList;
import com.casetudy_module4.codegym.model.contact.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract, Long> {
    //    @Query(value = "SELECT c.id, c.start_date as startDate,ifnull(group_concat(af.name),'No additional attachfacility included!!!') as attachFacilityName, c.end_date as endDate, c.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue FROM contract c LEFT JOIN contract_detail cd ON c.id = cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY totalValue desc"
//            ,countQuery="SELECT c.id, c.start_date as startDate,ifnull(group_concat(af.name),'No additional attachfacility included!!!') as attachFacilityName, c.end_date as endDate, c.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue FROM contract c LEFT JOIN contract_detail cd ON c.id = cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY totalValue desc"
//            , nativeQuery = true)
    @Query(value = "SELECT c.id, c.start_date as startDate, c.end_date as endDate, c.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue FROM contract c LEFT JOIN contract_detail cd ON c.id = cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY totalValue desc"
            , countQuery = "SELECT c.id, c.start_date as startDate, c.end_date as endDate, c.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue FROM contract c LEFT JOIN contract_detail cd ON c.id = cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY totalValue desc"
            , nativeQuery = true)
    Page<ContractDtoList> showListContract(Pageable pageable);
}
