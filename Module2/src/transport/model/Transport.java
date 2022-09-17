package transport.model;

public class Transport {
    private String licensePlate;
    private Manufacturer manufacturer;
    private int yearManufacture;
    private String Owner;

    public Transport(String licensePlate, Manufacturer manufacturer, int yearManufacture, String owner) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.yearManufacture = yearManufacture;
        this.Owner = owner;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public Transport() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    @Override
    public String toString() {
        return "Phương tiện{" +
                "Biển kiểm soát: " + licensePlate +
                ", Hãng SX: " + manufacturer +
                ", Năm SX: " + yearManufacture +
                ", Chủ sở hữu: " + Owner +
                '}';
    }
}
