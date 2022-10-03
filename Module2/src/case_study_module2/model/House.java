package case_study_module2.model;

public class House extends Facility{
      private String roomStandard;
      private int numberFloor;

    public House(String roomStandard, int numberFloor) {
        this.roomStandard = roomStandard;
        this.numberFloor = numberFloor;
    }

    public House() {
    }

    public House(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType, String roomStandard, int numberFloor) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberFloor = numberFloor;
    }

    public House(String serviceName, double usableArea, double rentalCosts, int maximumPeople, String rentalType) {
        super(serviceName, usableArea, rentalCosts, maximumPeople, rentalType);
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
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", numberFloor=" + numberFloor +
                '}'+super.toString();
    }
}
