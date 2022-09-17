package ss3_array.pratice;

import java.util.Scanner;

public class TemperatureConvert {
    public static void main(String[] args) {
        double F;
        double C;
        int choice = -1;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("choice: \n" + "1.ConverFtoC \n" + "2.ConvertCtoF \n" + "0.Exit");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("ConverFtoC: input F");
                    F = Integer.parseInt(input.nextLine());
                    System.out.println("ConverFtoC:" + ConvertFtoC(F));
                    break;
                case 2:
                    System.out.println("ConvertCtoF: input C");
                    C = Integer.parseInt(input.nextLine());
                    System.out.println("ConvertCtoF:" + ConvertCtoF(C));
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Wrong entry request! Please re-enter");
            }
        } while (true);
    }

    public static double ConvertFtoC(double F) {
        double C = (5.0 / 9) * (F - 32);
        return C;

    }

    public static double ConvertCtoF(double C) {
        double F = (9.0 / 5) * C + 32;
        return F;
    }
}
