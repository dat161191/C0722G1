package ss19_string_and_regex.exercise.validate_name_class;

import java.util.Scanner;

public class NameClassTest {
    private static final String strTest = "C0318G";
    private static final String strTest1 = "M0318G";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập lớp");
        String name = scanner.nextLine();
        NameClass nameClass = new NameClass();
        boolean isValidate;
        isValidate = nameClass.validate(name);
        System.out.println("NameClass: " + name + " is " + isValidate);

    }
}
