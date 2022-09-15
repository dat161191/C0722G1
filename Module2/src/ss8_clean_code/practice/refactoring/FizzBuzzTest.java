package ss8_clean_code.practice.refactoring;

public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(fizzBuzz.getNumber()));
        for (int i = 0; i < 50; i++) {
            System.out.println(FizzBuzz.fizzBuzz(i));
        }

    }
}
