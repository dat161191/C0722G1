package ss8_clean_code.practice.caculator;

public class Calculator {
    public static final char ADD='+';
    public static final char SUB='-';
    public static final char MUL='*';
    public static final char DIVI='/';
    public static double calculate(double firstOperand, double secondOperand, char operator) {

        switch (operator) {
            case ADD:
                return firstOperand + secondOperand;
            case SUB:
                return firstOperand - secondOperand;
            case MUL:
                return firstOperand * secondOperand;
            case DIVI:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
