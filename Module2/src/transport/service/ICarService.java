package transport.service;

public interface ICarService {
    void addCar();

    void displayCar();

    void removeCar(String LicensePlate);

    void findCar(String LicensePlate);
}
