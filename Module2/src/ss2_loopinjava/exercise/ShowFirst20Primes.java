package ss2_loopinjava.exercise;

import java.util.Scanner;

public class ShowFirst20Primes {
    public static void main(String[] args) {
        int number;
        int amountPrimes = 0;
        int N = 2;
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số lượng số nguyên tố ");
        number = input.nextInt();
        while (amountPrimes < number) {
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (N % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(N+",");
                amountPrimes++;
            }
            N++;
        }
    }


}
