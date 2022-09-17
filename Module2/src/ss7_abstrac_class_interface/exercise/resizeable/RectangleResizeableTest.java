package ss7_abstrac_class_interface.exercise.resizeable;

public class RectangleResizeableTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("Diện tích ban đầu: " + rectangle.getArena());
        rectangle.resize(rectangle.getWidth());
        rectangle.resize(rectangle.getHeight());
        System.out.println("Diện tích sau khi thay đổi: " + rectangle.getArena());
    }
}
