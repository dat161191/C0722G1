package com.casetudy_module4.codegym.dto.facility_dto;
import com.casetudy_module4.codegym.model.facility.FacilityType;
import com.casetudy_module4.codegym.model.facility.RentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
@Builder
@AllArgsConstructor
@Getter
public class FacilityDto {
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;
}
