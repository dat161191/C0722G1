package ss7_abstrac_class_interface.practice.class_animal_interface_edible;

import java.util.Arrays;

public class AbstractAndInterfaceTests {
    public static <animal> void main(String[] args) {
        Animal[] animals = new Animal[2];
//        Animal animal = new Tiger();
//        Animal animal1 = animal;
//        System.out.println(animal1.makeSound());
        animals[0] = new Tiger();
        animals[1] = new Chicken();

        for (Animal i : animals) {
            System.out.println(i.makeSound());
            if (i instanceof Chicken) {
                Edible edibler = (Chicken) i;
                System.out.println(edibler.howToEat());
                System.out.println(edibler.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
