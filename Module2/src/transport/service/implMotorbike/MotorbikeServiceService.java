package transport.service.implMotorbike;

import transport.model.Car;
import transport.model.Manufacturer;
import transport.model.Motorbike;
import transport.service.IMotorbikeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorbikeServiceService implements IMotorbikeService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Motorbike> motorbikes = new ArrayList<>();

    @Override
    public void addMotorbike() {
        Motorbike motorbike = infoMotorbike();
        motorbikes.add(motorbike);
        System.out.println("Thêm mới thành công");

    }

    @Override
    public void displayMotorbike() {
        for (Motorbike i : motorbikes) {
            System.out.println(i);
        }

    }

    @Override
    public void removeMotorbike(String LicensePlate) {
        boolean flagDelete = false;
        for (int i = 0; i < motorbikes.size(); i++) {
            if (motorbikes.get(i).getLicensePlate().equals(LicensePlate)) {
                System.out.println("Bạn có chắc muốn xóa phương tiện này này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    motorbikes.remove(i);
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
    public void findMotorbike(String LicensePlate) {
        boolean flagDelete = false;
        for (int i = 0; i < motorbikes.size(); i++) {
            if (motorbikes.get(i).getLicensePlate().contains(LicensePlate)) {
                System.out.println(motorbikes.get(i));
            }
            flagDelete = true;
            break;
        }
        if (!flagDelete) {
            System.out.println("Motorbike: Không tìm thấy đối tượng cần tìm.");
        }

    }

    public Motorbike infoMotorbike() {
        System.out.print("Mời bạn nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Mời bạn chọn hãng sãn xuất\n"
                + "1.HONDA\n" + "2.YAMAHA\n" + "3.BMW\n");
        int choice = Integer.parseInt(scanner.nextLine());
        List<Manufacturer> motorbikeList = new ArrayList<>();
        Manufacturer manufacturer1 = new Manufacturer("Honda1611", "HONDA", "Việt Nam");
        Manufacturer manufacturer2 = new Manufacturer("YaMaHa1611", "YAMAHA", "Nhật Bản");
        Manufacturer manufacturer3 = new Manufacturer("Bmw1611", "BMW", "Đức");
        motorbikeList.add(manufacturer1);
        motorbikeList.add(manufacturer2);
        motorbikeList.add(manufacturer3);
        Manufacturer manufacturer = null;
        switch (choice) {
            case 1:
                manufacturer = motorbikeList.get(0);
                break;
            case 2:
                manufacturer = motorbikeList.get(1);

                break;
            case 3:
                manufacturer = motorbikeList.get(2);

                break;
            default:
                System.out.println("Chưa có hãng sản xuất bạn muốn chọn");

        }
        System.out.print("Mời bạn nhập năm sản xuất: ");
        int yearManufacture = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập công suất: ");
        double wattage = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập tên chủ sở hữu");
        String Owner = scanner.nextLine();
        return new Motorbike(licensePlate, manufacturer, yearManufacture, Owner, wattage);
    }
}
