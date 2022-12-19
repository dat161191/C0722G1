package com.casetudy_module4.codegym.dto.facility_dto;
import com.casetudy_module4.codegym.model.facility.FacilityType;
import com.casetudy_module4.codegym.model.facility.RentType;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
//    public FacilityDto() {
//    }
//
//    public FacilityDto(Integer id, String name, Integer area, Double cost, Integer maxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, String facilityFree, RentType rentType, FacilityType facilityType) {
//        this.id = id;
//        this.name = name;
//        this.area = area;
//        this.cost = cost;
//        this.maxPeople = maxPeople;
//        this.standardRoom = standardRoom;
//        this.descriptionOtherConvenience = descriptionOtherConvenience;
//        this.poolArea = poolArea;
//        this.numberOfFloors = numberOfFloors;
//        this.facilityFree = facilityFree;
//        this.rentType = rentType;
//        this.facilityType = facilityType;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getArea() {
//        return area;
//    }
//
//    public void setArea(Integer area) {
//        this.area = area;
//    }
//
//    public Double getCost() {
//        return cost;
//    }
//
//    public void setCost(Double cost) {
//        this.cost = cost;
//    }
//
//    public Integer getMaxPeople() {
//        return maxPeople;
//    }
//
//    public void setMaxPeople(Integer maxPeople) {
//        this.maxPeople = maxPeople;
//    }
//
//    public String getStandardRoom() {
//        return standardRoom;
//    }
//
//    public void setStandardRoom(String standardRoom) {
//        this.standardRoom = standardRoom;
//    }
//
//    public String getDescriptionOtherConvenience() {
//        return descriptionOtherConvenience;
//    }
//
//    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
//        this.descriptionOtherConvenience = descriptionOtherConvenience;
//    }
//
//    public Double getPoolArea() {
//        return poolArea;
//    }
//
//    public void setPoolArea(Double poolArea) {
//        this.poolArea = poolArea;
//    }
//
//    public Integer getNumberOfFloors() {
//        return numberOfFloors;
//    }
//
//    public void setNumberOfFloors(Integer numberOfFloors) {
//        this.numberOfFloors = numberOfFloors;
//    }
//
//    public String getFacilityFree() {
//        return facilityFree;
//    }
//
//    public void setFacilityFree(String facilityFree) {
//        this.facilityFree = facilityFree;
//    }
//
//    public RentType getRentType() {
//        return rentType;
//    }
//
//    public void setRentType(RentType rentType) {
//        this.rentType = rentType;
//    }
//
//    public FacilityType getFacilityType() {
//        return facilityType;
//    }
//
//    public void setFacilityType(FacilityType facilityType) {
//        this.facilityType = facilityType;
//    }
}
