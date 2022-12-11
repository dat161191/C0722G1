package com.casetudy_module4.codegym.model.facility;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE facility SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    @Column(columnDefinition = "TEXT")
    private String facilityFree;
    @ManyToOne
    private RentType rentType;
    @ManyToOne
    private FacilityType facilityType;
    private boolean deleted = false;
}
