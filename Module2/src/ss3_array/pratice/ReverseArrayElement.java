package ss3_array.pratice;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayElement {
    public static void main(String[] args) {
        int amount;
        int[] array;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Nhập số phần tử mảng ");
            amount = Integer.parseInt(input.nextLine());
            if (amount > 20 || amount < 0) {
                System.out.println("Vui lòng nhập lại số phần tử mảng mảng ");
            }
        } while (amount > 20 || amount < 0);
        array = new int[amount];
        for (int i = 0; i < amount; i++) {
            System.out.printf("nhập giá trị phần tử %d ", i);
            array[i] = Integer.parseInt(input.nextLine());
        }
        System.out.println(Arrays.toString(array));
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[array.length - 1 - j];
            array[array.length - 1 - j] = temp;
        }System.out.println(Arrays.toString(array));
    }
}
