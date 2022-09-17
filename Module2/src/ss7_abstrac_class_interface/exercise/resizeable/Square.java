package ss7_abstrac_class_interface.exercise.resizeable;

public class Square extends Geometry implements Resizeable {
    private double squaredAngle = 10.5;

    public Square() {
    }

    public Square(double squaredAngle) {
        this.squaredAngle = squaredAngle;
    }

    public double getSquaredAngle() {
        return squaredAngle;
    }

    public void setSquaredAngle(double squaredAngle) {
        this.squaredAngle = squaredAngle;
    }
    public double getArena(){
        return Math.pow(squaredAngle,2);
    }

    @Override
    public String name() {
        return "Square";
    }

    @Override
    public void resize(double percent) {
        setSquaredAngle(squaredAngle+squaredAngle*(percent/100));
    }
}
