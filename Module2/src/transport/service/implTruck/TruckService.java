package transport.service.implTruck;

import transport.model.Manufacturer;
import transport.model.Truck;
import transport.service.ITruckService;
import transport.service.util.SortTruck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TruckService implements ITruckService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Truck> trucks = new ArrayList<>();
    static List<Manufacturer> manufacturerTruckList = new ArrayList<>();


    @Override
    public void addTruck() {
        Truck truck = infoTruck();
        trucks.add(truck);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayTruck() {
        for (Truck i : trucks) {
            System.out.println(i);
        }
    }

    @Override
    public void removeTruck(String LicensePlate) {
        boolean flagDelete = false;
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getLicensePlate().equals(LicensePlate)) {
                System.out.println("Bạn có chắc muốn xóa phương tiện (Truck) này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    trucks.remove(i);
                    System.out.println("Xóa thành công");
                    break;
                }
                flagDelete = true;

            }
        }
        if (!flagDelete) {
            System.out.println("Truck: Không tìm thấy đối tượng cần xóa.");
        }

    }

  /*  @Override
    public void findTruck(String LicensePlate) {
        boolean flagDelete = false;
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getLicensePlate().contains(LicensePlate)) {
                System.out.println(trucks.get(i));
            }
            flagDelete = true;
            break;
        }
        if (!flagDelete) {
            System.out.println("Truck: Không tìm thấy đối tượng cần tìm.");
        }

    }*/

    @Override
    public boolean findTruck1(String LicensePlate) {
        boolean flag = false;
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getLicensePlate().contains(LicensePlate)) {
                System.out.println(trucks.get(i));
            }
            flag = true;

        }
        return flag;
    }

    public Truck infoTruck() {
        System.out.print("Mời bạn nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Mời bạn chọn hãng sãn xuất\n"
                + "1.DAEWOO\n" + "2.ISUZU\n" + "3.TRƯỜNG HẢI\n");
        int choice = Integer.parseInt(scanner.nextLine());
        addManufacturer();
        Manufacturer manufacturer = null;
        switch (choice) {
            case 1:
                manufacturer = manufacturerTruckList.get(0);
                break;
            case 2:
                manufacturer = manufacturerTruckList.get(1);

                break;
            case 3:
                manufacturer = manufacturerTruckList.get(2);

                break;
            default:
                System.out.println("Chưa có hãng sản xuất bạn muốn chọn");

        }
        System.out.print("Mời bạn nhập năm sản xuất: ");
        int yearManufacture = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập trọng tải: ");
        double tonnage = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập tên chủ sở hữu");
        String Owner = scanner.nextLine();
        return new Truck(licensePlate, manufacturer, yearManufacture, Owner, tonnage);
    }

    public void addManufacturer() {
        manufacturerTruckList.add(new Manufacturer("DAEWOO1611", "DAEWOO", "Hàn Quốc"));
        manufacturerTruckList.add(new Manufacturer("ISUZU1611", "ISUZU", "Nhật Bản"));
        manufacturerTruckList.add(new Manufacturer("TRƯỜNG HẢI1611", "TRƯỜNG HẢI", "Việt Nam"));
    }

    @Override
    public void editTruck() {
        boolean flagDelete = false;
        System.out.println("Nhập bảng số xe cần sửa");
        String lincensePlate = scanner.nextLine();
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getLicensePlate().equals(lincensePlate)) {
                System.out.println("Bạn có chắc muốn sửa bảng số xe này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    System.out.println("Nhập thông tin cần sửa ");
                    String edit = scanner.nextLine();
                    trucks.get(i).setLicensePlate(edit);
                    System.out.println("Sửa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Trucks: Không tìm thấy đối tượng cần sửa.");
        }
    }

    @Override
    public void sortTruck() {
        Collections.sort(trucks,new SortTruck());
    }

    public void testAddTruck() {
        trucks.add(new Truck("05", manufacturerTruckList.get(1), 1995, "Jonh", 30));
        trucks.add(new Truck("02", manufacturerTruckList.get(0), 1905, "June", 10.5));
        trucks.add(new Truck("01", manufacturerTruckList.get(2), 1990, "Bill", 25));
        trucks.add(new Truck("04", manufacturerTruckList.get(1), 1995, "Anna", 20));
    }


}
