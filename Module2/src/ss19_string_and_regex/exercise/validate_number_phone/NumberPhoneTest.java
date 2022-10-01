package ss19_string_and_regex.exercise.validate_number_phone;

import java.util.Scanner;

public class NumberPhoneTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberPhone numberPhone = new NumberPhone();
        boolean isValidate;
        while (true) {
            System.out.println("Mời bạn nhập số ĐT");
            String number = scanner.nextLine();
            isValidate = numberPhone.validate(number);
            if (isValidate){
                System.out.println("NumberPhone: " + number + " is" + isValidate);
                break;
            }
      }
    }
}
