package ss6_inheritance.exercise.point2D_point3D;

import java.util.Arrays;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(Arrays.toString(point2D.getXY()));
        Point2D point2D1 = new Point2D(1, 2);
        point2D1.setXY(3, 4);
        System.out.println(Arrays.toString(point2D1.getXY()));
        System.out.println(point2D1.toString());
    }
}
