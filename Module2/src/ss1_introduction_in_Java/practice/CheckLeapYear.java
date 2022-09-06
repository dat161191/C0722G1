package ss1_introduction_in_Java.practice;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CheckLeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập năm: ");
        int year = Integer.parseInt(input.nextLine());
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " là năm nhuận");
        } else if (year % 100 == 0 && year % 400 == 0) {
            System.out.println(year + " là năm nhuận");
        } else {
            System.out.println(year + " là năm không nhuận");
        }
    }
}
