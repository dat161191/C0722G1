package ss3_array.exercise;

import java.util.Arrays;
import java.util.Scanner;
public class AddElement {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập độ dài của mảng: ");
            int number = Integer.parseInt(input.nextLine());
            int array[] = new int[number];
            System.out.println("Nhập các phần tử của mảng: ");
            for (int i = 0; i < number; i++) {
                System.out.println("Nhập phần tử thứ: " + i);
                array[i] = Integer.parseInt(input.nextLine());
            }
            System.out.println(Arrays.toString(array));
            System.out.println("Nhập số chèn vào: ");
            int num1 = Integer.parseInt(input.nextLine());
            System.out.println("Nhập vị trí cần chèn: ");
            int index = input.nextInt();
            if (index < 0 || index > array.length - 1) {
                System.out.println("Không thể chèn phần tử vào mảng: ");
            } else {
                for (int j = array.length - 1; j > index; j--) {
                    array[j] = array[j - 1];
                }
                array[index] = num1;
            }
            System.out.println("kết quả sau khi chèn: ");
            System.out.println(Arrays.toString(array));
    }
}
