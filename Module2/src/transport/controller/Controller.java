package transport.controller;

import transport.service.ICarService;
import transport.service.IMotorbikeService;
import transport.service.ITruckService;
import transport.service.implCar.CarService;
import transport.service.implMotorbike.MotorbikeServiceService;
import transport.service.implTruck.TruckService;

import java.util.Scanner;

public class Controller {
    private static Scanner input = new Scanner(System.in);
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
            System.out.println("5.Thoát");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("Lựa chon phương tiện cần thêm mới");
                        System.out.println("1.Ô tô");
                        System.out.println("2.Xe tải");
                        System.out.println("3.Xe máy");
                        System.out.println("4.Quay lại chương trình quản lý");
                        System.out.println("5.Thoát chương trình");
                        int choice1 = Integer.parseInt(input.nextLine());
                        switch (choice1) {
                            case 1:
                                iCarService.addCar();
                                break;
                            case 2:
                                iTruckService.addTruck();
                                break;
                            case 3:
                                iMotorbikeService.addMotorbike();
                                break;
                            case 4:
                                Controller.manageMenuTranSport();
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                System.out.println("Bạn đã nhập sai!Vui lòng nhập lại");
                        }
                    }
                case 2:

                    while (true) {
                        System.out.println("Lựa chon phương tiện cần Hiển thị");
                        System.out.println("1.Ô tô");
                        System.out.println("2.Xe tải");
                        System.out.println("3.Xe máy");
                        System.out.println("4.Quay lại chương trình quản lý");
                        System.out.println("5.Thoát chương trình");
                        int choice2 = Integer.parseInt(input.nextLine());
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
                                Controller.manageMenuTranSport();
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                System.out.println("Bạn đã nhập sai!Vui lòng nhập lại");
                        }
                    }
                case 3:
                    System.out.println("Nhập biển kiểm soát bạn cần xóa");
                    String LicensePlate = input.nextLine();
                    iTruckService.removeTruck(LicensePlate);
                    iCarService.removeCar(LicensePlate);
                    iMotorbikeService.removeMotorbike(LicensePlate);
                    break;
                case 4:
                    System.out.println("Nhập biển kiểm soát bạn cần tìm");
                    String LicensePlate1 = input.nextLine();
                    iTruckService.findTruck(LicensePlate1);
                    iCarService.findCar(LicensePlate1);
                    iMotorbikeService.findMotorbike(LicensePlate1);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Bạn đã nhập sai!Vui lòng nhập lại");
            }

        }

    }
}
