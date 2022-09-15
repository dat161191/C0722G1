package ss7_abstrac_class_interface.exercise.colorable;

public class Rectangle extends Shape{
    private double width;
    private double height;

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

    public Rectangle() {
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
