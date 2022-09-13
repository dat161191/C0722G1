package ss6_inheritance.exercise.point2D_point3D;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] array = {getX(), getY(), this.z};
        return array;
    }

    public void setXYZ(float x, float y, float z) {
        setXY(x, y);
        this.z = z;

    }

    @Override
    public String toString() {
//        return "Point3D{" +
//                "z=" + z + " x= " + getX() + " y= " + getY() + " " +
//                "tọa độ là: " + "(" + getX() +"," + getY() + "," + z+")"+
//        '}';
        return "Điểm có tọa độ: "+String.format("(%.2f,%.2f,%.2f)",getX(),getY(),z);

    }
}
