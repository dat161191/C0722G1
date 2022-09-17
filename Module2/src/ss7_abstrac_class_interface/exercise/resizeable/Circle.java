package ss7_abstrac_class_interface.exercise.resizeable;

public class Circle extends Geometry implements Resizeable {
    private double radius = 10;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void resize(double percent) {
        setRadius(radius + radius * (percent/100));
    }

    public double getArena() {
        return Math.PI * radius * radius;
    }

    @Override
    public String name() {
        return "Circle";
    }
}
