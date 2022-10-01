package ss19_string_and_regex.pratice.validate_email;

public class ValidateEmailTest {
    public static final String[] validEmail = new String[]{"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
    public static final String[] invalidEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};

    public static void main(String args[]) {
        ValidateEmail validate = new ValidateEmail();
        for (String email : validEmail) {
            boolean isvalid = validate.validate(email);
            System.out.println("Email is " + email + " is valid: " + isvalid);
        }
        for (String email : invalidEmail) {
            boolean isvalid = validate.validate(email);
            System.out.println("Email is " + email + " is valid: " + isvalid);
        }
    }
}
