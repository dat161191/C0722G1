package ss8_clean_code.practice.class_cylinder;

public class Cylinder {
    public static double getPerimeter(double radius) {
        return radius * 2 * Math.PI;
    }

    public static double getArea(double radius) {
        return Math.pow(radius, 2) * Math.PI;
    }

    public static double getVolume(double radius, double height) {
        return getPerimeter(radius) * 2 + 2*getArea(radius);
    }
}
