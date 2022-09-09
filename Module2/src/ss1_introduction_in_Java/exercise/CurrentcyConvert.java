package ss1_introduction_in_Java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CurrentcyConvert {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        float rate = 23000;
//        System.out.println("nhập vào usd: ");
//
//        float usd = input.nextFloat();
//        float vnd = usd * rate;
//        System.out.println(usd + " USD" + "=" + vnd + " VND");
        int[] a = {5, 6, 7, 8};

        for(int i=0; i < a.length; i++){

            if(a[i] % 2 == 0){

                continue;

            }
            System.out.println(i);
        }
    }
}