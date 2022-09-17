package ss3_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxInTwoDimensionalArrays {
    public static void main(String[] args) {
        int[][] array;
        int size;
        int size1;
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng ");
        size = Integer.parseInt(input.nextLine());
        System.out.print("Nhập đọ dài mảng con");
        size1 = Integer.parseInt(input.nextLine());
        array = new int[size][size1];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("Nhập phần tử trong mảng ");
                array[i][j] = Integer.parseInt(input.nextLine());
            }
            System.out.println(Arrays.toString(array[i]));
        }
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("số lớn nhất trong mảng là: " + max);
    }
}

