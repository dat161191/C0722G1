package transport.service.implCar;

import transport.model.Car;
import transport.model.Manufacturer;
import transport.service.ICarService;
import transport.service.util.SortCar;

import java.util.*;

public class CarService implements ICarService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Car> cars = new ArrayList<>();
    static List<Manufacturer> manufacturerCarList = new ArrayList<>();

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
                System.out.println("Bạn có chắc muốn xóa phương tiện (Car) này này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    cars.remove(i);
                    System.out.println("Xóa thành công");
                    break;
                }
                flagDelete = true;
            }
        }
        if (!flagDelete) {
            System.out.println("Car: Không tìm thấy đối tượng cần tìm.");
        }

    }

//    @Override
//    public void findCar(String LicensePlate) {
//        boolean flagDelete = false;
//        for (int i = 0; i < cars.size(); i++) {
//            if (cars.get(i).getLicensePlate().contains(LicensePlate)) {
//                System.out.println(cars.get(i));
//            }
//            flagDelete = true;
//            break;
//        }
//        if (!flagDelete) {
//            System.out.println("Car: Không tìm thấy đối tượng cần tìm.");
//        }
//
//    }

    @Override
    public boolean findCar1(String LicensePlate) {
        boolean flagDelete = false;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getLicensePlate().contains(LicensePlate)) {
                System.out.println(cars.get(i));
            }
            flagDelete = true;

        }
        return flagDelete;
    }

    public Car infoCar() {
        System.out.print("Mời bạn nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Mời bạn chọn hãng sãn xuất\n"
                + "1.Toyota\n" + "2.Ford\n" + "3.BMW\n");
        int choice = Integer.parseInt(scanner.nextLine());
        addManufacturer();
        Manufacturer manufacturer = null;
        switch (choice) {
            case 1:
                manufacturer = manufacturerCarList.get(0);
                break;
            case 2:
                manufacturer = manufacturerCarList.get(1);

                break;
            case 3:
                manufacturer = manufacturerCarList.get(2);

                break;
            default:
                System.out.println("Chưa có hãng sản xuất bạn muốn chọn");

        }


        System.out.print("Mời bạn nhập số ghế ngồi: ");
        int numberSeats = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập kiểu xe");
        String vehcileType = scanner.nextLine();
        System.out.print("Mời bạn nhập tên chủ sở hữu");
        String Owner = scanner.nextLine();
        return new Car(licensePlate, manufacturer, CheckException.yearManufacturer(), Owner, numberSeats, vehcileType);
    }

    public void addManufacturer() {
        manufacturerCarList.add(new Manufacturer("Toyota1611", "TOYOTA", "Nhật Bản"));
        manufacturerCarList.add(new Manufacturer("Ford1611", "FORD", "Mỹ"));
        manufacturerCarList.add(new Manufacturer("Bmw1611", "BMW", "Đức"));
    }

    public void testAddCar() {
        cars.add(new Car("06", manufacturerCarList.get(1), 1995, "Jonh", 30, "Thể thao"));
        cars.add(new Car("05", manufacturerCarList.get(0), 1965, "June", 30, "Thể thao"));
        cars.add(new Car("01", manufacturerCarList.get(2), 1985, "Adam", 30, "Thể thao"));
        cars.add(new Car("05", manufacturerCarList.get(2), 1985, "Ada", 30, "Thể thao"));
    }

    @Override
    public void editCar() {
        boolean flagDelete = false;
        System.out.println("Nhập bảng số xe cần sửa");
        String lincensePlate = scanner.nextLine();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getLicensePlate().equals(lincensePlate)) {
                System.out.println("Bạn có chắc muốn sửa bảng số xe này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    System.out.println("Nhập thông tin cần sửa ");
                    String edit = scanner.nextLine();
                    cars.get(i).setLicensePlate(edit);
                    System.out.println("Sửa thành công");
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
    public void sortCar() {
        Collections.sort(cars, new SortCar());
    }
}
