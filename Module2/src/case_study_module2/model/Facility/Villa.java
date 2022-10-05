package case_study_module2.model.Facility;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int numberFloor;

    public Villa() {
    }

    public Villa(String roomStandard, double poolArea, int numberFloor) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public Villa(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String serviceCode) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType, serviceCode);
    }

    public Villa(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String serviceCode, String roomStandard, double poolArea, int numberFloor) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType, serviceCode);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberFloor=" + numberFloor +
                '}';
    }
}
