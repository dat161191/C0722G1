package ss6_inheritance.exercise.point_moveAblePoint;

import java.util.Arrays;

public class PoitTest {
    public static void main(String[] args) {
        Point point=new Point();
        System.out.println(point.toString());
        Point point1=new Point(5,10);
        System.out.println(Arrays.toString(point1.getXY()));
        point.setXY(10,20);
        System.out.println(point.toString());
    }
}
