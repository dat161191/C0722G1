package ss3_array.pratice;

public class MinInArray {
    public static void main(String[] args) {
        int[] array = {46, 2, 8, 9, 4, 10};
        int value;
        value = minValue(array);
        System.out.print("min in araay "+ value);
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
