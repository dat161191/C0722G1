package ss2_loopinjava.practice;

import java.util.Scanner;

public class BankInterest {
    public static void main(String[] args) {
        double money, month;
        double yearInterest;
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số tiền gởi:");
        money = input.nextDouble();
        System.out.print("Nhập số tháng gởi:");
        month = input.nextInt();
        System.out.print("Nhập lãi suất năm:");
        yearInterest = input.nextDouble();
        for (int i = 0; i < month; i++) {
            money += money * ((yearInterest / 100) * month / 12);
        }
        System.out.println("Tiền lãi ngân hàng là" + money);
    }
}
