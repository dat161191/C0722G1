package ss1_introduction_in_Java.exercise;

import java.util.Scanner;

public class ReadNumbersIntoWords1 {
    public static void main(String[] args) {
        System.out.println("nhập số cần đọc");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (number < 10 && number >= 0) {
            switch (number) {
                case 0:
                    System.out.println(number + " zero");
                    break;
                case 1:
                    System.out.println(number + " one");
                    break;
                case 2:
                    System.out.println(number + " two");
                    break;
                case 3:
                    System.out.println(number + " three");
                    break;
                case 4:
                    System.out.println(number + " four");
                    break;
                case 5:
                    System.out.println(number + " five");
                    break;
                case 6:
                    System.out.println(number + " six");
                    break;
                case 7:
                    System.out.println(number + " seven");
                    break;
                case 8:
                    System.out.println(number + " eight");
                    break;
                case 9:
                    System.out.println(number + " nine");
                    break;

            }
        } else if (number < 20) {
            switch (number % 10) {
                case 0:
                    System.out.println("ten");
                    break;
                case 1:
                    System.out.println("eleven");
                    break;
                case 2:
                    System.out.println("twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 4:
                    System.out.println("fourteen");
                    break;
                case 5:
                    System.out.println("fifteen");
                    break;
                case 6:
                    System.out.println("sixteen");
                    break;
                case 7:
                    System.out.println("seventeen");
                    break;
                case 8:
                    System.out.println("eighteen");
                    break;
                case 9:
                    System.out.println("nineteen");
                    break;
            }
        } else if (number < 1000) {
            String dozen;
            String units;
            String hundreds;

            switch (number / 100) {
                case 1:
                    hundreds = "onehundreds";
                    break;
                case 2:
                    hundreds = "twohundreds";
                    break;
                case 3:
                    hundreds = "threehundreds";
                    break;
                case 4:
                    hundreds = "fourhundreds";
                    break;
                case 5:
                    hundreds = "fivehundreds";
                    break;
                case 6:
                    hundreds = "sixhundreds";
                    break;
                case 7:
                    hundreds = "sevenhundreds";
                    break;
                case 8:
                    hundreds = "eighthundreds";
                    break;
                case 9:
                    hundreds = "ninehundreds";
                    break;
                default:
                    hundreds = "";

            }

            if (number % 100 < 20 && number % 100 > 10) {
                switch (number % 100) {
                    case 11:
                        dozen = "eleven";
                        break;
                    case 12:
                        dozen = "twelve";
                        break;
                    case 13:
                        dozen = "thirteen";
                        break;
                    case 14:
                        dozen = "fourteen";

                        break;
                    case 15:
                        dozen = "fifteen";

                        break;
                    case 16:
                        dozen = "sixteen";

                        break;
                    case 17:
                        dozen = "seventeen";

                        break;
                    case 18:
                        dozen = "eighteen";

                        break;
                    case 19:
                        dozen = "nineteen";
                        break;
                    default:
                        dozen = "";
                }
                switch ((number % 100) % 10) {
                    default:
                        units = "";

                }
            } else {
                switch ((number % 100) / 10) {
                    case 1:
                        dozen = "ten";
                        break;
                    case 2:
                        dozen = "twenty";
                        break;
                    case 3:
                        dozen = "thirty";
                        break;
                    case 4:
                        dozen = "fourty";
                        break;
                    case 5:
                        dozen = "fifty";
                        break;
                    case 6:
                        dozen = "sixty";
                        break;
                    case 7:
                        dozen = "seventy";
                        break;
                    case 8:
                        dozen = "eightty";
                        break;
                    case 9:
                        dozen = "ninety";
                        break;
                    default:
                        dozen = "";
                }
                switch ((number % 100) % 10) {

                    case 1:
                        units = "one";
                        break;
                    case 2:
                        units = "two";
                        break;
                    case 3:
                        units = "three";
                        break;
                    case 4:
                        units = "four";
                        break;
                    case 5:
                        units = "five";
                        break;
                    case 6:
                        units = "six";
                        break;
                    case 7:
                        units = "seven";
                        break;
                    case 8:
                        units = "eight";
                        break;
                    case 9:
                        units = "nine";
                        break;
                    default:
                        units = "";
                }
            }

            if (!hundreds.equals("") || !dozen.equals("") || !units.equals(""))
                System.out.printf("The  '%d' is %s ", number, hundreds + " " + dozen + " " + " " + units);
            else System.out.print("Invalid input!");
        }
    }
}
