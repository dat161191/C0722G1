package case_study_module2.model.Facility;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String serviceCode) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType, serviceCode);
    }

    public Room(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String serviceCode, String freeService) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType, serviceCode);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
