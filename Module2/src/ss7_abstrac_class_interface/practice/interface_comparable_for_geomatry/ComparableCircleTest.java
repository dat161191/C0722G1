package ss7_abstrac_class_interface.practice.interface_comparable_for_geomatry;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle();
        circles[1] = new ComparableCircle("indigo", false, 3.5);
        circles[2] = new ComparableCircle("indigo", false, 5.5);

        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        System.out.println(circles[0].compareTo(circles[1]));
        Arrays.sort(circles);
        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);

        }
    }
}
