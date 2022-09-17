package transport.service.implCar;

import transport.model.Car;
import transport.model.Manufacturer;
import transport.model.Truck;
import transport.service.ICarService;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService implements ICarService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Car> cars = new ArrayList<>();

    @Override
    public void addCar() {
        Car car = infoCar();
        cars.add(car);
        System.out.println("Thêm mới thành công");

    }

    @Override
    public void displayCar() {
        for (Car i : cars) {
            System.out.println(i);
        }

    }

    @Override
    public void removeCar(String LicensePlate) {
        boolean flagDelete = false;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getLicensePlate().equals(LicensePlate)) {
                System.out.println("Bạn có chắc muốn xóa phương tiện này này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    cars.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Car: Không tìm thấy đối tượng cần tìm.");
        }

    }

    @Override
    public void findCar(String LicensePlate) {
        boolean flagDelete = false;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getLicensePlate().contains(LicensePlate)) {
                System.out.println(cars.get(i));
            }
            flagDelete = true;
            break;
        }
        if (!flagDelete) {
            System.out.println("Car: Không tìm thấy đối tượng cần tìm.");
        }

    }

    public Car infoCar() {
        System.out.print("Mời bạn nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Mời bạn chọn hãng sãn xuất\n"
                + "1.Toyota\n" + "2.Ford\n" + "3.BMW\n");
        int choice = Integer.parseInt(scanner.nextLine());
        List<Manufacturer> carList = new ArrayList<>();
        Manufacturer manufacturer1 = new Manufacturer("Toyota1611", "TOYOTA", "Nhật Bản");
        Manufacturer manufacturer2 = new Manufacturer("Ford1611", "FORD", "Mỹ");
        Manufacturer manufacturer3 = new Manufacturer("Bmw1611", "BMW", "Đức");
        carList.add(manufacturer1);
        carList.add(manufacturer2);
        carList.add(manufacturer3);
        Manufacturer manufacturer = null;
        switch (choice) {
            case 1:
                manufacturer = carList.get(0);
                break;
            case 2:
                manufacturer = carList.get(1);

                break;
            case 3:
                manufacturer = carList.get(2);

                break;
            default:
                System.out.println("Chưa có hãng sản xuất bạn muốn chọn");

        }
        System.out.print("Mời bạn nhập năm sản xuất: ");
        int yearManufacture = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập số ghế ngồi: ");
        int numberSeats = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập kiểu xe");
        String vehcileType = scanner.nextLine();
        System.out.print("Mời bạn nhập tên chủ sở hữu");
        String Owner = scanner.nextLine();
        return new Car(licensePlate, manufacturer, yearManufacture, Owner, numberSeats, vehcileType);
    }
}
