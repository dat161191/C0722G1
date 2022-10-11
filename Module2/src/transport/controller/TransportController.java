package transport.controller;

import transport.service.ICarService;
import transport.service.IMotorbikeService;
import transport.service.ITruckService;
import transport.service.implCar.CarService;
import transport.service.implMotorbike.MotorbikeServiceService;
import transport.service.implTruck.TruckService;

import java.util.Scanner;

public class TransportController {
    private static final Scanner scanner = new Scanner(System.in);
    static ITruckService iTruckService = new TruckService();
    static ICarService iCarService = new CarService();
    static IMotorbikeService iMotorbikeService = new MotorbikeServiceService();

    public static void manageMenuTranSport() {

        while (true) {
            System.out.println("Chương trình quản lý phương tiện giao thông");
            System.out.println("Nhập lựa chọn của bạn");
            System.out.println("1.Thêm mới phương tiện");
            System.out.println("2.Hiển thị phương tiện");
            System.out.println("3.Xóa phương tiện theo biển kiểm soát");
            System.out.println("4.Tìm kiếm theo biển kiểm soát");
            System.out.println("5.Sửa thông tin biển kiểm soát");
            System.out.println("6.Sắp xếp theo biển kiểm soát");
            System.out.println("7.Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    TransportController.addMeNu();
                    break;
                case 2:
                    TransportController.displayMenu();
                    break;
                case 3:
                    System.out.println("Nhập biển kiểm soát bạn cần xóa");
                    String LicensePlate = scanner.nextLine();
                    iTruckService.removeTruck(LicensePlate);
                    iCarService.removeCar(LicensePlate);
                    iMotorbikeService.removeMotorbike(LicensePlate);
                    break;
                case 4:
                    TransportController.findMenu();
                    break;
                case 5:
                    TransportController.editMeNu();
                    break;
                case 6:
                    TransportController.sortMeNu();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Bạn đã nhập sai!Vui lòng nhập lại");
            }

        }

    }

    private static void sortMeNu() {
        loop:
        while (true) {
            System.out.println("Lựa chon phương tiện cần sắp xếp");
            System.out.println("1.Ô tô");
            System.out.println("2.Xe tải");
            System.out.println("3.Xe máy");
            System.out.println("4.Quay lại chương trình quản lý");
            System.out.println("Sắp xếp theo biển kiểm soát nếu giống nhau sắp theo năm sản xuất");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iCarService.sortCar();
                    break;
                case 2:
                    iTruckService.sortTruck();
                    break;
                case 3:
                    iMotorbikeService.sortMotorbike();
                    break;
                case 4:
                    break loop;
            }
        }
        }

        private static void editMeNu () {
            loop:
            while (true) {
                System.out.println("Lựa chon phương tiện cần sửa");
                System.out.println("1.Ô tô");
                System.out.println("2.Xe tải");
                System.out.println("3.Xe máy");
                System.out.println("4.Quay lại chương trình quản lý");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        iCarService.editCar();
                        break;
                    case 2:
                        iTruckService.editTruck();
                        break;
                    case 3:
                        iMotorbikeService.editMotorbike();
                        break;
                    case 4:
                        break loop;
                }
            }
        }

        private static void displayMenu () {
            while (true) {
                System.out.println("Lựa chon phương tiện cần Hiển thị");
                System.out.println("1.Ô tô");
                System.out.println("2.Xe tải");
                System.out.println("3.Xe máy");
                System.out.println("4.Quay lại chương trình quản lý");
                System.out.println("5.Thoát chương trình");
                int choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2) {
                    case 1:
                        iCarService.displayCar();
                        break;
                    case 2:
                        iTruckService.displayTruck();
                        break;
                    case 3:
                        iMotorbikeService.displayMotorbike();
                        break;
                    case 4:
                        TransportController.manageMenuTranSport();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Bạn đã nhập sai!Vui lòng nhập lại");
                }
            }
        }

        private static void addMeNu () {
            while (true) {
                System.out.println("Lựa chon phương tiện cần thêm mới");
                System.out.println("1.Ô tô");
                System.out.println("2.Xe tải");
                System.out.println("3.Xe máy");
                System.out.println("4.Quay lại chương trình quản lý");
                System.out.println("5.Thoát chương trình");
                int choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1) {
                    case 1:
//                        iCarService.addCar();
                    iCarService.addManufacturer();
                    iCarService.testAddCar();
                        break;
                    case 2:
                        iTruckService.addManufacturer();
                        iTruckService.testAddTruck();
//                    iTruckService.addTruck();
                        break;
                    case 3:
                        iMotorbikeService.addManufacturer();
                        iMotorbikeService.testAddMotorbike();
//                    iMotorbikeService.addMotorbike();
                        break;
                    case 4:
                        TransportController.manageMenuTranSport();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Bạn đã nhập sai!Vui lòng nhập lại");
                }
            }
        }

        public static void findMenu () {
            System.out.println("Nhập biển kiểm soát bạn cần tìm");
            String LicensePlate1 = scanner.nextLine();
            boolean isFound = (iMotorbikeService.findMotorbike1(LicensePlate1) && iTruckService.findTruck1(LicensePlate1)
                    && iCarService.findCar1(LicensePlate1));
            if (!isFound) {
                System.out.println("Không tìm thấy đối tượng trong danh sách");
            }
        }

    }
