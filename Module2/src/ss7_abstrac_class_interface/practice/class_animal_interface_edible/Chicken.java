package ss7_abstrac_class_interface.practice.class_animal_interface_edible;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound(){
        return "Chicken: hello everybody!";
    }
    @Override
    public String howToEat() {
        return "Chicken: could be fried";
    }
}
