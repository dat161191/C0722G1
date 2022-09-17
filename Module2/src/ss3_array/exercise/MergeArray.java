package ss3_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int[] array1 = new int[5];
        int[] array2 = new int[4];
        int[] array3 = new int[array1.length + array2.length];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < array1.length; i++) {
            System.out.printf("Nhập phần tử %d ", i);
            array1[i] = Integer.parseInt(input.nextLine());
        }
        System.out.println(Arrays.toString(array1));
        for (int i = 0; i < array2.length; i++) {
            System.out.printf("Nhập phần tử %d ", i);
            array2[i] = Integer.parseInt(input.nextLine());

        }
        System.out.println(Arrays.toString(array2));
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        System.out.println(Arrays.toString(array3));
        for (int i = 0; i < array2.length; i++) {
            array3[array1.length + i]=array2[i];

        }
        System.out.println(Arrays.toString(array3));
    }

}
