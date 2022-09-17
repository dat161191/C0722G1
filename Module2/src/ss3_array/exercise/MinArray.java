package ss3_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MinArray {
    public static void main(String[] args) {
        int[] array;
        int value;
        int size;
        Scanner input=new Scanner(System.in);
        System.out.println("Nhập độ dài của mảng: ");
        size = Integer.parseInt(input.nextLine());
        array = new int[size];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập phần tử thứ: " + i);
            array[i] = Integer.parseInt(input.nextLine());
        }
        System.out.println(Arrays.toString(array));
        value = minValue(array);
        System.out.print("min in araay " + value);
    }

    public static int minValue(int[] arr) {
        int min = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
