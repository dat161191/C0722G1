package ss7_abstrac_class_interface.exercise.colorable;

import ss7_abstrac_class_interface.exercise.interface_resizeable.Circle;

import java.util.Arrays;

public class ColorableTest {
    public static void main(String[] args) {
        Geomatix[] geomatix = new Geomatix[2];
        geomatix[0] = new Square();
        geomatix[1] = new Circle10();
        for (Geomatix i : geomatix) {
            System.out.printf("Diện tích các hình: %.2f \n", i.getArena());
        }
        for (Geomatix i : geomatix) {
            if (i instanceof Colorable) {
                System.out.println(((Colorable) i).howToColor());
            }
            }
        }
    }
