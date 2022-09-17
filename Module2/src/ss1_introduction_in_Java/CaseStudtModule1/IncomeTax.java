package ss1_introduction_in_Java.CaseStudtModule1;

import java.util.Scanner;

public class IncomeTax {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int netSalary;
        int tax;
        System.out.print("nhập tiền lương: ");
        int salary = Integer.parseInt(input.nextLine());
        if (salary > 15000000) {
            tax = salary * 20 / 100;
        } else if (salary > 7000000) {
            tax = salary * 10 / 100;
        } else {
            tax = salary * 5 / 100;
        }
        netSalary = salary - tax;
        System.out.println("lương thực nhận là" + netSalary);

    }
}
