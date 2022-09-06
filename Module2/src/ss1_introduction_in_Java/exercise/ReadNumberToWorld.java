package ss1_introduction_in_Java.exercise;

import java.util.Scanner;

public class ReadNumberToWorld {
    public String Units(int number) {
        String result = "";

        switch (number) {
            case 0:
                result = "zero ";
                break;
            case 1:
                result = "one ";
                break;
            case 2:
                result = "two ";
                break;
            case 3:
                result = "three ";
                break;
            case 4:
                result = "four ";
                break;
            case 5:
                result = "five ";
                break;
            case 6:
                result = "six ";
                break;
            case 7:
                result = "seven ";
                break;
            case 8:
                result = "eight ";
                break;
            case 9:
                result = "nine ";
                break;
        }
        return result;
    }

    public String Dozen(int number) {
        String result1 = "";
        if (number / 10 == 1) {
            switch (number % 10) {
                case 0:
                    result1 = "ten ";
                    break;
                case 1:
                    result1 = "eleven ";
                    break;
                case 2:
                    result1 = "twelve ";
                    break;
                case 3:
                    result1 = "thirteen ";
                    break;
                case 4:
                    result1 = "fourteen ";
                    break;
                case 5:
                    result1 = "fifteen ";
                    break;
                case 6:
                    result1 = "sixteen ";
                    break;
                case 7:
                    result1 = "seventeen ";
                    break;
                case 8:
                    result1 = "eighteen ";
                    break;
                case 9:
                    result1 = "nineteen ";
                    break;
            }
            return result1;
        } else if (number / 10 > 1) {
            switch (number / 10) {
                case 2:
                    result1 = "twenty ";
                    break;
                case 3:
                    result1 = "thirty ";
                    break;
                case 4:
                    result1 = "fourty ";
                    break;
                case 5:
                    result1 = "fifty ";
                    break;
                case 6:
                    result1 = "sixty ";
                    break;
                case 7:
                    result1 = "seventy ";
                    break;
                case 8:
                    result1 = "eighty ";
                    break;
                case 9:
                    result1 = "ninety ";
                    break;
            }
        }
        if (number % 10 == 0) {
            return result1;
        }
        result1 += Units((number % 10));
        return result1;
    }

    public String Hundreds(int number) {
        String result2 = "";

        switch (number / 100) {
            case 1:
                result2 = "one hundred ";
                break;
            case 2:
                result2 = "two hundred ";
                break;
            case 3:
                result2 = "three hundred ";
                break;
            case 4:
                result2 = "four hundred ";
                break;
            case 5:
                result2 = "five hundred ";
                break;
            case 6:
                result2 = "six hundred ";
                break;
            case 7:
                result2 = "seven hundred ";
                break;
            case 8:
                result2 = "eight hundred ";
                break;
            case 9:
                result2 = "nine hundred ";
                break;
        }
        if (number % 100 == 0) {
            return result2;
        }

        result2 += Dozen(number % 100);
        return result2;
    }

    public static void main(String[] args) {
        int randomNumber;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("nhập số:");
            randomNumber = input.nextInt();
        } while (randomNumber < 0 || randomNumber > 999);
        ReadNumberToWorld number1 = new ReadNumberToWorld();
        if (randomNumber < 10) {
            System.out.println(number1.Units(randomNumber));
        } else if (randomNumber < 100) {
            System.out.println(number1.Dozen(randomNumber));
        } else if (randomNumber < 1000) {
            System.out.println(number1.Hundreds(randomNumber));
        }
    }
}

