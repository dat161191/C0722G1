package ss7_abstrac_class_interface.exercise.resizeable;

public class CircleResizeableTest {
    public static void main(String[] args) {
        Circle circle=new Circle();
        System.out.println("Diện tích ban đầu: "+circle.getArena());
        circle.resize(circle.getRadius());
        System.out.println(circle.getArena());
        circle.resize(circle.getRadius());
        System.out.println("Diện tích sau khi thay đổi: " +circle.getArena());

    }
}
