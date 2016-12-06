package tn.enis.com.shock_detection_alert;

/**
 * Created by hrizi on 12/6/16.
 */

public class Params {
    private float x;
    private float y;
    private float z;
    private  long time;

    public Params() {
    }

    public Params(float x, float y, float z, long time) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.time = time;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
