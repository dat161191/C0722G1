package ss6_inheritance.practice.geometric_objects;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle("indigo", true, 3.5);
        System.out.println(circle);
    }
}
