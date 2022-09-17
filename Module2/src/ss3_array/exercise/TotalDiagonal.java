package ss3_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TotalDiagonal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = inputSize();
        int size1 = inputSize();

        int sum = 0;
        int sum1 = 0;
        int[][] array = new int[size][size1];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("Nhập phần tử ");
                array[i][j] = Integer.parseInt(input.nextLine());
            }
            System.out.println(Arrays.toString(array[i]));
        }
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        System.out.println("Độ dài đường chéo là " + sum);
//        for (int i = 0; i < array.length; i++) {
//            sum1 += array[i][array.length - 1 - i];
//        }
//        System.out.println("Độ dài đường chéo 2 là " + sum1);
    }

    static int inputSize() {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhập độ dài mảng ");
            size = Integer.parseInt(input.nextLine());
        } while (size < 0);
        return size;
    }
}
