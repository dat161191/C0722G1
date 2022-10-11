package transport.service;

public interface ICarService {
    void addCar();

    void displayCar();

    void removeCar(String LicensePlate);

//    void findCar(String LicensePlate);
    boolean findCar1(String LicensePlate);

    void addManufacturer();

    void testAddCar();

    void editCar();

     void sortCar();
}
