package ss7_abstrac_class_interface.exercise.resizeable;

public class SquareResizeableTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println("Diện tích ban đầu: " + square.getArena());
        square.resize(square.getSquaredAngle());
        System.out.println("Diện tích sau khi thay đổi: " + square.getArena());
    }
}
