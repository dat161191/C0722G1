package transport.service.implCar;

import transport.service.util.TransportException;

import java.util.Scanner;

public class CheckException {
    static Scanner scanner = new Scanner(System.in);

    public static int yearManufacturer() {
        int yearManufacture;
        while (true) {
            try {
                System.out.print("Mời bạn nhập năm sản xuất: ");
                yearManufacture = Integer.parseInt(scanner.nextLine());
                if (yearManufacture < 0) {
                    throw new TransportException("Bạn đã nhập sai");
                }
                break;
            } catch (TransportException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Bạn đã nhập sai ! Vui lòng nhập lại");
            }
        }
        return yearManufacture;
    }
}
