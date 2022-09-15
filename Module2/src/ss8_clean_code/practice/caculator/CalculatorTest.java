package ss8_clean_code.practice.caculator;

public class CalculatorTest {
    public static void main(String[] args) {
        double a = Math.random() * 100;
        double b = Math.random() * 100;
        System.out.printf("a = %.2f , b = %.2f\n", a, b);
        System.out.printf("Phép + nè: %.2f \n", Calculator.calculate(a, b, '+'));
        System.out.printf("Phép - nè: %.2f \n", Calculator.calculate(a, b, '-'));
        System.out.printf("Phép * nè: %.2f \n", Calculator.calculate(a, b, '*'));
        System.out.printf("Phép / nè: %.2f \n", Calculator.calculate(a, b, '/'));
    }
}
