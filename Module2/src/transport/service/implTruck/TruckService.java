package transport.service.implTruck;

import school_manager.model.Student;
import transport.model.Manufacturer;
import transport.model.Truck;
import transport.service.ITruckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckService implements ITruckService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Truck> trucks = new ArrayList<>();

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
                System.out.println("Bạn có chắc muốn xóa phương tiện này này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    trucks.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Truck: Không tìm thấy đối tượng cần xóa.");
        }

    }

    @Override
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

    }

    public Truck infoTruck() {
        System.out.print("Mời bạn nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Mời bạn chọn hãng sãn xuất\n"
                + "1.DAEWOO\n" + "2.ISUZU\n" + "3.TRƯỜNG HẢI\n");
        int choice = Integer.parseInt(scanner.nextLine());
        List<Manufacturer> TruckList = new ArrayList<>();
        Manufacturer manufacturer1 = new Manufacturer("DAEWOO1611", "DAEWOO", "Hàn Quốc");
        Manufacturer manufacturer2 = new Manufacturer("ISUZU1611", "ISUZU", "Nhật Bản");
        Manufacturer manufacturer3 = new Manufacturer("TRƯỜNG HẢI1611", "TRƯỜNG HẢI", "Việt Nam");
        TruckList.add(manufacturer1);
        TruckList.add(manufacturer2);
        TruckList.add(manufacturer3);
        Manufacturer manufacturer = null;
        switch (choice) {
            case 1:
                manufacturer = TruckList.get(0);
                break;
            case 2:
                manufacturer = TruckList.get(1);

                break;
            case 3:
                manufacturer = TruckList.get(2);

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
}
