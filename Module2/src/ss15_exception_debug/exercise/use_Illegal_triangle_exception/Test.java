package ss15_exception_debug.exercise.use_Illegal_triangle_exception;

import java.util.Scanner;

public class Test {
    static double edgeA;
    static double edgeB;
    static double edgeC;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhập cạnh A");
                edgeA = Double.parseDouble(scanner.nextLine());
                checkEdge(edgeA);
                break;
            } catch (IllegalTriangleException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Cạnh sai định dạng");
            }
        }
        while (true) {
            try {
                System.out.println("Nhập cạnh B");
                edgeB = Double.parseDouble(scanner.nextLine());
                if (edgeB < 0) {
                    throw new IllegalTriangleException("Chiều dài cạnh sai");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Cạnh sai định dạng");
            }
        }
        while (true) {
            try {
                System.out.println("Nhập cạnh C");
                edgeC = Double.parseDouble(scanner.nextLine());
                checkEdge(edgeC);
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Cạnh sai định dạng");
            }
        }
        try {
            checkEdgeTriangle(edgeC, edgeB, edgeA);


        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }

    static void checkEdge(double e) throws IllegalTriangleException {
        if (e < 0) {
            throw new IllegalTriangleException("Chiều dài cạnh sai");
        }
    }

    static void checkEdgeTriangle(double c, double b, double a) throws IllegalTriangleException {
        double sumAB = edgeA + edgeB;
        double sumAC = edgeA + edgeC;
        double sumBC = edgeB + edgeC;
        if (c > sumAB || b > sumAC || a > sumBC) {
            throw new IllegalTriangleException("Đây không phải 3 cạnh tam giác");
        } else {
            System.out.println("Đây là 3 cạnh tam giác");
        }
    }
}
