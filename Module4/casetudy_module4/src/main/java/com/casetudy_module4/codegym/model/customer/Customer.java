package com.casetudy_module4.codegym.model.customer;


import com.casetudy_module4.codegym.model.contact.Contract;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE customer SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private CustomerType customerType;
    private String name;
    @Column(columnDefinition = "date")
    private String dateOfBirth;
    private boolean gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    private Boolean deleted = false;
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;
}
