package ss8_clean_code.practice.class_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        double radius = Math.random() * 100;
        double height = Math.random() * 100;
        System.out.println(radius + " , "+height);
        System.out.println(Cylinder.getArea(radius));
        System.out.println(Cylinder.getPerimeter(radius));
        System.out.println(Cylinder.getVolume(radius,height));
    }
}
