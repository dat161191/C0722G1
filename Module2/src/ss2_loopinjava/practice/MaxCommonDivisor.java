package ss2_loopinjava.practice;

import java.util.Scanner;

public class MaxCommonDivisor {
    public static void main(String[] args) {
        int number1, number2;
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số thứ nhất: ");
        number1 = input.nextInt();
        System.out.print("Nhập số thứ hai: ");
        number2 = input.nextInt();
        while (number1 != number2) {
            if (number1 > number2) {
                number1 = number1 - number2;
            } else {
                number2 -= number1;
            }
        }
        int maxCommonDivisor = number1;
        System.out.println("ước chung lớn nhất là: " + maxCommonDivisor);
    }
}
