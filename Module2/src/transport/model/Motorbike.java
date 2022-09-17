package transport.model;

public class Motorbike extends Transport {
    private double wattage;

    public Motorbike(double wattage) {
        this.wattage = wattage;
    }

    public Motorbike() {
    }

//    public Motorbike(String licensePlate, String manufacturer, int yearManufacture, String owner, double wattage) {
//        super(licensePlate, manufacturer, yearManufacture, owner);
//        this.wattage = wattage;
//    }

    public Motorbike(String licensePlate, Manufacturer manufacturer, int yearManufacture, String owner, double wattage) {
        super(licensePlate, manufacturer, yearManufacture, owner);
        this.wattage = wattage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "wattage=" + wattage +
                '}' + super.toString();
    }
}
