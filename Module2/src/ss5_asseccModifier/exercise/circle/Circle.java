package ss5_asseccModifier.exercise.circle;

public class Circle {
    private double radius = 1.0;
    private String Str = "Red";

    Circle() {
    }

    Circle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArena() {
        return Math.PI * Math.pow(radius, 2);
    }


}
