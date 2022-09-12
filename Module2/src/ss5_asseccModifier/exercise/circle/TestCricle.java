package ss5_asseccModifier.exercise.circle;

public class TestCricle {
    public static void main(String[] args) {
        Circle circle = new Circle(3.5);
        System.out.println(circle.getRadius());
        System.out.println(circle.getArena());
        circle.setRadius(4.5);
        System.out.println(circle.getArena());
    }
}
