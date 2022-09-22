package ss13_search_algorithm.exercise.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchByRecursive {
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 5, 4, 3, 8, 10, 9};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int index=binarySearch(arr,6,1,9);
        System.out.println(index);
    }

    static int binarySearch(int[] arr, int k, int left, int right) {
        if (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (k < arr[mid]) {
                return binarySearch(arr, k, left, mid - 1);
            }
            return binarySearch(arr, k, left + 1, mid);
        }
        return -1;
    }

}
