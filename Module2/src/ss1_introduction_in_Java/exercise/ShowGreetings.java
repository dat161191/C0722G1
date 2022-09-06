package ss1_introduction_in_Java.exercise;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ShowGreetings {
    public static void main(String[] args) {
        System.out.println("Enter your name:");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Hello:" + name);
    }
}
