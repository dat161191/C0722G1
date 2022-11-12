package service;

import model.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAllFacility();

    boolean addFacility(Facility facility);

    boolean removeFacility(int id);

    boolean editFacility(int id, Facility facility);

    Facility findByID(int id);

    List<Facility> searchByName(String name);
}
