package ss11_dsa_stack_queue.exercise.reverse_in_stack;

public class Crud {
    public static void reverse(StringBuilder s) {
        int n = s.length();
        MyStack obj = new MyStack(n);

        int i;
        for (i = 0; i < n; i++) {
            obj.push(s.charAt(i));
        }

        for (i = 0; i < n; i++) {
            char ch = obj.pop();
            s.setCharAt(i, ch);
        }
    }
}
