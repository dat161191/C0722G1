package case_study_module2.model;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String freeService) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType);
        this.freeService = freeService;
    }

    public Room(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType);
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}'+super.toString();
    }
}
