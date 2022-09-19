package ss11_dsa_stack_queue.exercise.convert_decima_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thập phân");
        int number = Integer.parseInt(scanner.nextLine());
        Stack<Integer> stack = new Stack<>();
        while (number != 0) {
            stack.push(number % 2);
            number /= 2;
        }
        System.out.println(stack);
        System.out.print("Số thập phân chuyển sang nhị phân là: ");
        while (!(stack.isEmpty())){
            System.out.printf("%d",stack.pop());
        }
    }
}
