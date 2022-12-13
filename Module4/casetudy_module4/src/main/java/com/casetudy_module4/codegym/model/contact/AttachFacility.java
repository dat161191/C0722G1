package com.casetudy_module4.codegym.model.contact;

import javax.persistence.*;
import java.util.Set;


import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE blog contract deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double cost;

    private String unit;

    private String status;
    @Column(columnDefinition = "boolean default false")
    private Boolean deleted = false;
    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetails;
}
