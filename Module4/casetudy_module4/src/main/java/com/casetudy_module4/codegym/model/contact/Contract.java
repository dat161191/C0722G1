package com.casetudy_module4.codegym.model.contact;

import com.casetudy_module4.codegym.model.customer.Customer;
import com.casetudy_module4.codegym.model.employee.Employee;
import com.casetudy_module4.codegym.model.facility.Facility;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//@SQLDelete(sql = "UPDATE blog contract deleted = true WHERE id=?")
//@Where(clause = "deleted=false")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "date")
    private String startDate;

    @Column(columnDefinition = "date")
    private String endDate;

    private double deposit;
    @Column(columnDefinition = "boolean default false")
    private Boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facility;

}
