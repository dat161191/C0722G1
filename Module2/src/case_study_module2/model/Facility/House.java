package case_study_module2.model.Facility;

public class House extends Facility {
    private String roomStandard;
    private int numberFloor;

    public House(String roomStandard, int numberFloor) {
        this.roomStandard = roomStandard;
        this.numberFloor = numberFloor;
    }

    public House() {
    }

    public House(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String serviceCode, String roomStandard, int numberFloor) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType, serviceCode);
        this.roomStandard = roomStandard;
        this.numberFloor = numberFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", numberFloor=" + numberFloor +
                '}';
    }
}
