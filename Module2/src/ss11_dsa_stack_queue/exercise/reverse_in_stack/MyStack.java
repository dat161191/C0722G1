package ss11_dsa_stack_queue.exercise.reverse_in_stack;

public class MyStack {
    int size;
    int top;
    char[] a;

    public MyStack() {

    }

    boolean isEmpty() {
        return (top < 0);
    }

    public MyStack(int n) {
        top = -1;
        size = n;
        a = new char[size];
    }

    void push(char x) {
        if (top >= size) {
            System.out.println("Stack Overflow");
        } else {
            a[++top] = x;
        }
    }

    char pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[top--];
        }
    }
}
