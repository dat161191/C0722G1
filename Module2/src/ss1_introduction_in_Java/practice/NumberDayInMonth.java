package ss1_introduction_in_Java.practice;

import java.util.Scanner;

public class NumberDayInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Xin moi nhap thang: ");
        int month = Integer.parseInt(scanner.nextLine());

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Thang nay co 31 ngay!");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Thang nay co 30 ngay!");
                break;
            case 2:
                System.out.println("Co 28 hoac 29 ngay");
                break;
            default:
                System.out.println("Nhap sai roi!");
        }

    }
}
