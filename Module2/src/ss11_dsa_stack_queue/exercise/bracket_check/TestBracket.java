package ss11_dsa_stack_queue.exercise.bracket_check;

import java.util.Scanner;
import java.util.Stack;

public class TestBracket {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập biểu thức");
        String str=scanner.nextLine();
        String[] strArr = str.split("");
        Stack<String> stack1 = new Stack<>();
        boolean check = true;
        String left = "";

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("(")) {
                stack1.push(strArr[i]);
            } else if (strArr[i].equals(")")) {
                if (stack1.isEmpty()) {
                    check = false;
                    break;
                } else {
                    left = stack1.pop();
                    if (!left.equals("(") ) {
                        check = false;
                        break;
                    }
                }
            }
            if (i == strArr.length - 1) {
                check = stack1.isEmpty();
            }
        }

        if (check) {
            System.out.println("This expression is true");
        } else {
            System.out.println("This expression is not false");

        }
    }
}

