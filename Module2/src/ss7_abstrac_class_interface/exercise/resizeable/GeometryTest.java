package ss7_abstrac_class_interface.exercise.resizeable;


public class GeometryTest {
    public static void main(String[] args) {
        Geometry[] geomatixes = new Geometry[3];
        geomatixes[0] = new Circle();
        geomatixes[1] = new Square();
        geomatixes[2] = new Rectangle();
        for (Geometry i : geomatixes) {
            System.out.printf("Diện tích ban đầu của hình %s là: %.2f \n", i.name(), i.getArena());
        }
        for (Geometry i : geomatixes) {
            ((Resizeable) i).resize(Math.floor(Math.random() * 100 + 1));
        }
        for (Geometry i : geomatixes) {
            System.out.printf("Diện tích sau khi tăng của hình %s là: %.2f \n", i.name(), i.getArena());
        }
    }
}
