package ss7_abstrac_class_interface.exercise.interface_resizeable;

import ss7_abstrac_class_interface.exercise.colorable.Geomatix;

import java.util.Arrays;

public class GeometryTest {
    public static void main(String[] args) {
//        double[] arrayBefor = new double[3];
//        Rectangle rectangle = new Rectangle();
//        arrayBefor[0] = rectangle.getArena();
//        Circle circle = new Circle();
//        arrayBefor[1] = circle.getArena();
//        Square square = new Square();
//        arrayBefor[2] = square.getArena();
//        System.out.println("mảng diện tích các hình ban đầu: "+Arrays.toString(arrayBefor));
//        rectangle.resize(Math.floor(Math.random()*100+1));
//        circle.resize(Math.floor(Math.random()*100+1));
//        square.resize(Math.floor(Math.random()*100+1));
//        double[] arrayAfter= new double[3];
//        arrayAfter[0]=rectangle.getArena();
//        arrayAfter[1]=circle.getArena();
//        arrayAfter[2]=square.getArena();
//        System.out.println("mảng diện tích các hình sau khi thay đổi: "+Arrays.toString(arrayAfter));
        Geomatix1[] geomatixes = new Geomatix1[3];
        geomatixes[0] = new Circle();
        geomatixes[1] = new Square();
        geomatixes[2] = new Rectangle();
        for (Geomatix1 i : geomatixes) {
            System.out.printf("Diện tích ban đầu của hình %s là: %.2f \n", i.name(), i.getArena());
        }
        for (Geomatix1 i : geomatixes
        ) {
            ((Resizeable) i).resize(Math.floor(Math.random() * 100 + 1));
        }
        for (Geomatix1 i : geomatixes
        ) {
            System.out.printf("Diện tích sau khi tăng của hình %s là: %.2f \n", i.name(), i.getArena());
        }
    }
}
