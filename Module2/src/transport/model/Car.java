package transport.model;

public class Car extends Transport {
    private int numberSeats;
    private String vehicleType;

    public Car() {
    }

    public Car(int numberSeats, String vehiclType) {
        this.numberSeats = numberSeats;
        this.vehicleType = vehiclType;
    }

//    public Car(String licensePlate, String manufacturer, int yearManufacture, String owner, int numberSeats, String vehicleType) {
//        super(licensePlate, manufacturer, yearManufacture, owner);
//        this.numberSeats = numberSeats;
//        this.vehicleType = vehicleType;
//    }

    public Car(String licensePlate, Manufacturer manufacturer, int yearManufacture, String owner, int numberSeats, String vehicleType) {
        super(licensePlate, manufacturer, yearManufacture, owner);
        this.numberSeats = numberSeats;
        this.vehicleType = vehicleType;
    }
    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getVehiclType() {
        return vehicleType;
    }

    public void setVehiclType(String vehiclType) {
        this.vehicleType = vehiclType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberSeats: " + numberSeats +
                ", vehiclType: " + vehicleType  +
                '}' + super.toString();
    }
}
