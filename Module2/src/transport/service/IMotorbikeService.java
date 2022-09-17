package transport.service;

public interface IMotorbikeService {
    void addMotorbike();
    void displayMotorbike();
    void removeMotorbike(String LicensePlate);
    void findMotorbike(String LicensePlate);
}
