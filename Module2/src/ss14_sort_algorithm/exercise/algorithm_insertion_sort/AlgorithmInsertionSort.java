package ss14_sort_algorithm.exercise.algorithm_insertion_sort;

import java.util.Arrays;

public class AlgorithmInsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void insertionSort(int[] array) {
        int pos, x;
        for (int i = 1; i < array.length; i++) {
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = x;
            System.out.print("List after the  " + i + "' sort: ");
            for (int key : list) {
                System.out.print(key + "\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        for (int j : list) {
            System.out.println("Your input list: " + j);
        }
        System.out.println("Mảng có các giá trị: "+ Arrays.toString(list));
        System.out.println("\nBegin sort processing...");
        insertionSort(list);
    }
}
