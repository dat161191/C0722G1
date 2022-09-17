package ss3_array.exercise;

import java.util.Scanner;

public class NumberOfOccurrences {
    public static void main(String[] args) {
        String str;
        int conut = 0;
        char characters;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi ");
        str = input.nextLine();
        System.out.println("nhập ký tự cần kiểm tra ");
        characters = input.nextLine().charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (characters == str.charAt(i)) {
                conut++;
            }
        }
        System.out.println("số lần xuất hiện của: " + characters + " là " + conut);
    }
}
