package ss7_abstrac_class_interface.practice.interface_comparable_for_geomatry;

import ss6_inheritance.practice.geometric_objects.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }


    @Override
    public int compareTo(ComparableCircle circle) {
        if (getRadius() > circle.getRadius()) return 1;
        else if (getRadius() < circle.getRadius()) return -1;
        else return 1;
    }
}
