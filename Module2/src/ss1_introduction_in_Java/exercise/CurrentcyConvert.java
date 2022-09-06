package ss1_introduction_in_Java.exercise;

import java.util.Scanner;

public class Currentcy_convert {
    public static void main(String[] args) {
        float rate = 23000;
        System.out.println("nhập vào usd: ");
        Scanner input = new Scanner(System.in);
        float usd = input.nextFloat();
        float vnd = usd * rate;
        System.out.println(usd + " USD" + "=" + vnd + " VND");
    }
}
