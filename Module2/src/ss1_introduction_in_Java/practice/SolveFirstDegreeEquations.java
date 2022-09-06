package ss1_introduction_in_Java.practice;

import java.util.Scanner;

public class SolveFirstDegreeEquations {
    public static void main(String[] args) {
        System.out.println("Giải phương trình");
        System.out.println("Cho một phương trình là 'a * x + b = c', vui lòng nhập các hằng số:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();
        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("kết quả là: %f", answer);
        } else {
            if (b == c) {
                System.out.print("Vô Số Nghiệm");
            } else {
                System.out.print("Vô Nghiệm");
            }

        }
    }
}



