package ss7_abstrac_class_interface.exercise.colorable;

public class ShapeTest {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(10.5);
        shape[1] = new Square(15.5);
        shape[2] = new Rectangle(5.5, 20);
        for (Shape i : shape) {
            System.out.println("Diện tích của hình " + i.getName() + " là: " + i.getArea());
            if (i instanceof Colorable) {
                ((Colorable) i).howToColor();
            }
        }
    }
}
