package case_study_module2.service.implFacilityService;

import case_study_module2.model.Facility;
import case_study_module2.service.IFacilityService;

import java.util.*;

public class FacilityService implements IFacilityService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Facility, Integer> facilityList = new LinkedHashMap<>();

    @Override
    public void displayFacility() {
        for (Facility i : facilityList) {
            System.out.println("");
        }
    }

    @Override
    public void addFacility() {
//        Facility facility =
//        facilityList.add(facility);
        System.out.println("Successfully added new!");
    }



    @Override
    public void displayFacilityMaintenance() {

    }
}
