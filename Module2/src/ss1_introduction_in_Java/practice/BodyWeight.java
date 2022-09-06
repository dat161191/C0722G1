package ss1_introduction_in_Java.practice;

import java.util.Scanner;

public class BodyWeight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập cân nặng: ");
        float weight = input.nextFloat();
        System.out.println("Nhập chiều cao: ");
        float height = input.nextFloat();
        float bmi = (float) (weight / Math.pow(height, 2));
        System.out.println("Chỉ số bmi là: " + bmi);
        if (bmi < 18.5) {
            System.out.println(bmi + " is Underweight");
        } else if (bmi < 25.0) {
            System.out.println(bmi + " is Normal");
        } else if (bmi < 30.0) {
            System.out.println(bmi + " is Overweight");
        } else {
            System.out.println(bmi + " is Obese");
        }
    }
}
