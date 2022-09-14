package ss7_abstrac_class_interface.exercise.colorable;

public class Square extends Geomatix implements Colorable {
    private double edge = 10.5;

    public Square() {
    }

    public Square(double edge) {
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public double getArena() {
        return Math.pow(edge,2);
    }

    @Override
    public String howToColor() {
        return "Color all four sides";
    }
}
