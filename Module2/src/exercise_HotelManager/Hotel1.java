package exercise_HotelManager;

public class Hotel1 {
    private int numberOfRentalDays1;
    private String typeOfRoom1;
    private double roomRates1;

    public Hotel1() {
        super();
    }

    public Hotel1(int numberOfRentalDays1, String typeOfRoom1, double roomRates1) {
        super();
        this.numberOfRentalDays1 = numberOfRentalDays1;
        this.typeOfRoom1 = typeOfRoom1;
        this.roomRates1 = roomRates1;
    }

    @Override
    public String toString() {
        return "Hotel1{" +
                "numberOfRentalDays1=" + numberOfRentalDays1 +
                ", typeOfRoom1='" + typeOfRoom1 + '\'' +
                ", roomRates1=" + roomRates1 +
                '}';
    }

    public double totalMoney() {
        return numberOfRentalDays1 * roomRates1;
    }
}
