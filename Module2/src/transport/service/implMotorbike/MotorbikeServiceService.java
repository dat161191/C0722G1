package transport.service.implMotorbike;

import transport.model.Car;
import transport.model.Manufacturer;
import transport.model.Motorbike;
import transport.service.IMotorbikeService;
import transport.service.util.SortMotorbike;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MotorbikeServiceService implements IMotorbikeService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Motorbike> motorbikes = new ArrayList<>();
    static List<Manufacturer> motorbikeManufacturerList = new ArrayList<>();


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
                System.out.println("Bạn có chắc muốn xóa phương tiện Motorbike này này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    motorbikes.remove(i);
                    System.out.println("Xóa thành công");
                    break;
                }
                flagDelete = true;
            }
        }
        if (!flagDelete) {
            System.out.println("Motorbike: Không tìm thấy đối tượng cần xóa.");
        }

    }



  /*  @Override
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

    }*/

    @Override
    public boolean findMotorbike1(String LicensePlate) {
        boolean flag = false;
        for (int i = 0; i < motorbikes.size(); i++) {
            if (motorbikes.get(i).getLicensePlate().contains(LicensePlate)) {
                System.out.println(motorbikes.get(i));
            }
            flag = true;

        }
        return flag;
    }

    @Override
    public void addManufacturer() {
        motorbikeManufacturerList.add(new Manufacturer("Honda1611", "HONDA", "Việt Nam"));
        motorbikeManufacturerList.add(new Manufacturer("YaMaHa1611", "YAMAHA", "Nhật Bản"));
        motorbikeManufacturerList.add(new Manufacturer("Bmw1611", "BMW", "Đức"));
    }

    @Override
    public void testAddMotorbike() {
        motorbikes.add(new Motorbike("02", motorbikeManufacturerList.get(0), 1905, "Hà", 10));
        motorbikes.add(new Motorbike("01", motorbikeManufacturerList.get(0), 1905, "Hà", 10));
        motorbikes.add(new Motorbike("01", motorbikeManufacturerList.get(1), 1970, "An", 15));
        motorbikes.add(new Motorbike("03", motorbikeManufacturerList.get(2), 1965, "Bình", 8));
    }

    @Override
    public void editMotorbike() {
        boolean flagDelete = false;
        System.out.println("Nhập bảng số xe cần sửa");
        String lincensePlate = scanner.nextLine();
        for (int i = 0; i < motorbikes.size(); i++) {
            if (motorbikes.get(i).getLicensePlate().equals(lincensePlate)) {
                System.out.println("Bạn có chắc muốn sửa bảng số xe này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    System.out.println("Nhập thông tin cần sửa ");
                    String edit = scanner.nextLine();
                    motorbikes.get(i).setLicensePlate(edit);
                    System.out.println("Sửa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Motorbike: Không tìm thấy đối tượng cần tìm.");
        }

    }

    @Override
    public void sortMotorbike() {
        Collections.sort(motorbikes,new SortMotorbike());
    }


    public Motorbike infoMotorbike() {
        System.out.print("Mời bạn nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Mời bạn chọn hãng sãn xuất\n"
                + "1.HONDA\n" + "2.YAMAHA\n" + "3.BMW\n");
        int choice = Integer.parseInt(scanner.nextLine());
        addManufacturer();
        Manufacturer manufacturer = null;
        switch (choice) {
            case 1:
                manufacturer = motorbikeManufacturerList.get(0);
                break;
            case 2:
                manufacturer = motorbikeManufacturerList.get(1);

                break;
            case 3:
                manufacturer = motorbikeManufacturerList.get(2);

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
