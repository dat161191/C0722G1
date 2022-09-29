package transport.service;

public interface IMotorbikeService {
    void addMotorbike();
    void displayMotorbike();
    void removeMotorbike(String LicensePlate);
//    void findMotorbike(String LicensePlate);
    boolean findMotorbike1(String LicensePlate);

    void addManufacturer();

    void testAddMotorbike();

    void editMotorbike();

    void sortMotorbike();
}
