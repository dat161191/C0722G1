package ss4_oop.exercise;

import java.util.Scanner;

public class QuadraticEquation {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nhập a: ");
        double a = Integer.parseInt(input.nextLine());
        System.out.print("Nhập b: ");
        double b = Integer.parseInt(input.nextLine());
        System.out.print("Nhập c: ");
        double c = Integer.parseInt(input.nextLine());
        ClassQuadraticEquation quadraticEquation = new ClassQuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("Nghiệm 1 là: " + quadraticEquation.getRoot1());
            System.out.println("Nghiệm 2 là: " + quadraticEquation.getRoo2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("Phương trình có 1 nghiệm: " + quadraticEquation.getdoubleRoot());

        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }

    public static class ClassQuadraticEquation {
        double a;
        double b;
        double c;

        public ClassQuadraticEquation(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

        public double getC() {
            return c;
        }

        public double getDiscriminant() {
            return this.b * this.b - this.a * this.c * 4;
        }

        public double getRoot1() {
            return (-this.b + Math.sqrt(getDiscriminant())) / (2 * this.a);
        }

        public double getRoo2() {
            return (-this.b - Math.sqrt(getDiscriminant())) / (2 * this.a);
        }

        public double getdoubleRoot() {
            return -this.b / (2 * this.a);
        }


        @Override
        public String toString() {
            return "ClassQuadraticEquation{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }
    }
}
