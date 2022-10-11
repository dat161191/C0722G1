package demo;

import java.util.*;

public class Test {
    public int rong, dai;

    static public int X = 2;

    public static void main(String[] args) {
        Test o1 = new Test();
        Test o2 = new Test();
        o2.X = 5;
        System.out.printf("x=%d, y=%d, z=%d", o1.X, o2.X, Test.X);
    }
}
