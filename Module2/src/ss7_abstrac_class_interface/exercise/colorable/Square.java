package ss7_abstrac_class_interface.exercise.colorable;

public class Square extends Shape implements Colorable {
    private double egle;

    public Square() {
    }

    public Square(double egle) {
        this.egle = egle;
    }

    public double getEgle() {
        return egle;
    }

    public void setEgle(double egle) {
        this.egle = egle;
    }


    @Override
    public double getArea() {
        return Math.pow(egle,2);
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public void howToColor() {
        System.out.println("Sqare say: thích tô sao tô");
    }
}
