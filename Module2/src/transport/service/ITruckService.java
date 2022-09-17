package transport.service;

public interface ITruckService {
    void addTruck();
    void displayTruck();
    void removeTruck(String LicensePlate);
    void findTruck(String LicensePlate);
}
