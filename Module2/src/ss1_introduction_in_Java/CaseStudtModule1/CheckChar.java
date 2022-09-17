package ss1_introduction_in_Java.CaseStudtModule1;

import java.util.Scanner;

public class CheckChar {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String str = "ouiaeOUIAE";
        int count = 0;
        System.out.print("Nhập ký tự cần kiểm tra ");
        char character = input.nextLine().charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (character == str.charAt(i)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("không phải nguyên âm ");
        }else {
            System.out.println("đây là nguyên âm ");
        }
    }
}
