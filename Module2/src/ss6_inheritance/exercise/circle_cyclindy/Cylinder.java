package ss6_inheritance.exercise.circle_cyclindy;

public class Cylinder extends Circle {
    private double height = 15.0;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBottomArea() {
        return getArena();
    }

    public double getVolume() {
        return getArena() * getHeight();
    }

    @Override
    public String toString() {
        return "Cylinder{" + super.toString() +
                " chiều cao= " + height + " 'diện tích đáy & thể tích là:' " + getBottomArea() + " --&-- " + getVolume() +
                '}';
    }
}
