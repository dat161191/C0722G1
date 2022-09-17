package ss7_abstrac_class_interface.exercise.resizeable;

public class Rectangle extends Geometry implements Resizeable {
    private double width = 5;
    private double height = 10;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void resize(double percent) {
        setHeight(height + height * (percent / 100));
        setWidth(width + width * (percent / 100));
    }

    public double getArena() {
        return width * height;
    }

    @Override
    public String name() {
        return "Rectangle";
    }
}
