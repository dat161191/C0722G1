package exercise_HotelManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m;
        Hotel1 hotel1;
        Human1 human1;
        ArrayList<Human1> arrHuman1 = new ArrayList<>();
        System.out.print("Nhập số lượng khách thuê phòng: ");
        m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            System.out.println("Nhập thông tin khách hàng thứ " + (i + 1) + ":");
            System.out.print("Nhập họ tên khách hàng: ");
            String fullName = scanner.nextLine();
            System.out.print("Nhập quê quán: ");
            String queQuan = scanner.nextLine();
            System.out.print("Nhập số chứng minh nhân dân: ");
            String idCard = scanner.nextLine();
            human1 = new Human1(fullName, queQuan, idCard);
            arrHuman1.add(human1);
        }
        ArrayList<Hotel1> arrHotel1 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            System.out.println("Nhập thông tin thuê phòng khách thứ : " + (i + 1) + ":");
            System.out.print("Nhập số ngày trọ: ");
            int numberOfRentalDays = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập loại phòng: ");
            String typeOfRoom = scanner.nextLine();
            System.out.print("Nhập giá phòng: ");
            double roomRates = Double.parseDouble(scanner.nextLine());
            hotel1 = new Hotel1(numberOfRentalDays, typeOfRoom, roomRates);
            arrHotel1.add(hotel1);
            System.out.println(arrHotel1.get(i));
        }
//        for (int i = 0; i < arrHuman1.size(); i++) {
//            System.out.println("Thông tin khachs hàng thứ " + (i + 1) + ": ");
//            System.out.println(arrHuman1.get(i).toString());
//        }
//        for (int i = 0; i < arrHotel1.size(); i++) {
//            System.out.println("\nThông tin thuê phòng khách hàng thứ " + (i + 1) + ": ");
//            System.out.println(arrHotel1.get(i).toString());
//        }
//        System.out.println("\nNhập số chứng minh nhân dân của khách trả phòng: ");
//        String tim = scanner.nextLine();
//        for (int i = 0; i < m; i++) {
//            if (arrHuman1.get(i).getIdCard1().equalsIgnoreCase(tim)) {
//                System.out.println("Số tiền thuê phòng là: " + arrHotel1.get(i).totalMoney());
//            }
//        }


    }
}
