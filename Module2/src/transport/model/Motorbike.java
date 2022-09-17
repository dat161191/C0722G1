package transport.model;

public class Motorcycle extends Transport {
    private double wattage;

    public Motorcycle(double wattage) {
        this.wattage = wattage;
    }

    public Motorcycle() {
    }

    public Motorcycle(String licensePlate, String manufacturer, int yearManufacture, double wattage) {
        super(licensePlate, manufacturer, yearManufacture);
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
