package ss19_string_and_regex.pratice.account_create;

public class AccountExampleTest {
    public static final String[] validAccount = new String[]{"123abc_", "_abc123", "______", "123456", "abcdefgh"};
    public static final String[] invalidAccount = new String[]{".@", "12345", "1234_", "abcde"};

    public static void main(String[] args) {
        AccountExample accountExample = new AccountExample();
        for (String i : validAccount) {
            boolean isValid = accountExample.validate(i);
            System.out.println("Account is " + i + " is valid: " + isValid);
        }
        for (String i : invalidAccount) {
            boolean isValid = accountExample.validate(i);
            System.out.println("Account is " + i + " is valid: " + isValid);
        }
    }
}
