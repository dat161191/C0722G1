package transport.model;

public class Truck extends Transport {
    private double tonnage;

    public Truck() {
    }

    public Truck(double tonnage) {
        this.tonnage = tonnage;
    }

//    public Truck(String licensePlate, String manufacturer, int yearManufacture, String owner, double tonnage) {
//        super(licensePlate, manufacturer, yearManufacture, owner);
//        this.tonnage = tonnage;
//    }

    public Truck(String licensePlate, Manufacturer manufacturer, int yearManufacture, String owner, double tonnage) {
        super(licensePlate, manufacturer, yearManufacture, owner);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "tonnage=" + tonnage +
                '}' + super.toString();
    }
}
