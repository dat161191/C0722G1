package ss7_abstrac_class_interface.exercise.colorable;

public class Circle extends Shape implements Colorable {
    private double radius;

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
    public void howToColor() {
        System.out.println("Hello everbody: thích thì tô");
    }

    @Override
    public double getArea() {
        return Math.pow(radius,2)*Math.PI;
    }

    @Override
    public String getName() {
        return "Circle";
    }
}
