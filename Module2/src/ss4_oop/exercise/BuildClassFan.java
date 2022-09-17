package ss4_oop.exercise;

public class BuildClassFan {
    final int RUN = 0;
    final int SLOW = 1;
    final int MEDIUM = 2;
    public final int FAST = 3;
    private int speed = RUN;
    private boolean on = false;
    private double radius = 15;
    private String color = "rainbow colors";

    public int getRUN() {
        return RUN;
    }

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFASST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BuildClassFan() {
    }

    public BuildClassFan(int speed, double radius, boolean on, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String toString() {
        return "BuildClassFan{" +
                "speed=" + speed +
                ", on=" + on +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        BuildClassFan fan1 = new BuildClassFan(0, 10, false, "blue");
        BuildClassFan fan2 = new BuildClassFan();
        fan2.setOn(true);
        fan2.speed = 3;
        System.out.println(fan2.toString());
        fan2.setOn(true);
        fan2.setSpeed(fan2.FAST);
        System.out.println(fan1.toString());

    }
}
