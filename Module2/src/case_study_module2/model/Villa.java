package case_study_module2.model;

public class Villa extends Facility {
    private String roomStandard;
    private double pooArea;

    public Villa() {
    }

    public Villa(String roomStandard, double pooArea) {
        this.roomStandard = roomStandard;
        this.pooArea = pooArea;
    }

    public Villa(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType);
    }

    public Villa(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String roomStandard, double pooArea) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.pooArea = pooArea;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPooArea() {
        return pooArea;
    }

    public void setPooArea(double pooArea) {
        this.pooArea = pooArea;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", pooArea=" + pooArea +
                '}'+super.toString();
    }
}
