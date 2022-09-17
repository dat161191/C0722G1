package ss2_loopinjava.practice;

import java.util.Scanner;

public class CheckPrimes {
    public static void main(String[] args) {
        int number;
        int count = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số cần kiểm tra");
        number = input.nextInt();
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                count += 1;
            }
        }
        if (count == 0) {
            System.out.println("Số này là số nguyên tố");
        } else {
            System.out.println("Số này không phải số nguyên tố");
        }
    }
}
