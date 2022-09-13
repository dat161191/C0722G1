package ss6_inheritance.exercise.point_moveAblePoint;

public class MoveAblePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveAblePoint() {
    }

    public MoveAblePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveAblePoint(float x, float y) {
        super(x, y);
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] array = {this.xSpeed, this.ySpeed};
        return array;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
//        return super.toString() + "," + "speed= " + "(" + this.xSpeed + "," + this.ySpeed + ")";
        return "Điểm có tọa độ và speed là:" +
                String.format("(%.2f,%.2f),speed=(%.2f,%.2f)", getX(), getY(), xSpeed, ySpeed);
    }

    public MoveAblePoint move() {
        setX(getX() + xSpeed);
        setY(getY() + xSpeed);
        return this;

    }

}
