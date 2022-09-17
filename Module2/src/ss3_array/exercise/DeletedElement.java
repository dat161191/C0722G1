package ss3_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DeletedElement {
    public static void main(String[] args) {
        int size;
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng ");
        size = Integer.parseInt(input.nextLine());
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("nhập phần tử %d ", i);
            array[i] = Integer.parseInt(input.nextLine());
        }
        System.out.print(Arrays.toString(array));
        System.out.println("Nhập phần tử cần xóa ");
        int X = Integer.parseInt(input.nextLine());
        boolean check=false;
        int index_del;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == X) {
                check=true;
                index_del = i;
                for (int j = index_del; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
                i--;
            }
        }

        if(check==false){
            System.out.println("Số có không trong mảng");
        } else {
            System.out.println("Số có trong mảng");
        }
        System.out.println(Arrays.toString(array));

    }

}


