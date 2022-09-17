package ss3_array.pratice;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
            System.out.println(Arrays.toString(array));
            int max = array[0];
            int index = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    index = j ;
                }
            }System.out.println("max in array " + max + " ,at position " + index);
        }
    }
}
