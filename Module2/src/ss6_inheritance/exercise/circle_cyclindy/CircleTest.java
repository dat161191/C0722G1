package ss6_inheritance.exercise.circle_cyclindy;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Circle circle1 = new Circle(12.5, "red");
        System.out.println(circle.toString());
        System.out.println(circle1.toString());
        System.out.println("Diện tích = " + circle.getArena() + "Chu vi = "+circle.getPerimeter());
        System.out.println("Diện tích = " + circle1.getArena() + "Chu vi = "+circle1.getPerimeter());
    }
}
