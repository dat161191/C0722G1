package ss7_abstrac_class_interface.exercise.colorable;

public class Circle10 extends Geomatix {
    private double radius=10;

    public Circle10(double radius) {
        this.radius = radius;
    }

    public Circle10() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArena(){
        return Math.PI*Math.pow(radius,2);
    }
}
