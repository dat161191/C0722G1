package transport.service;

public interface ITruckService {
    void addTruck();

    void displayTruck();

    void removeTruck(String LicensePlate);

//    void findTruck(String LicensePlate);

    boolean findTruck1(String LicensePlate);

    void testAddTruck();

    void addManufacturer();

    void editTruck();

    void sortTruck();
}
