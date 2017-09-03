package jp.rssh.orgabattlesaga;

/**
 * Created by t-araumi on 2017/09/03.
 */

public class Vector2D {
    public double aX, aY;
    public Vector2D(double x, double y){
        this.set(x, y);
    }
    public Vector2D clone(){
        return new Vector2D(this.aX, this.aY);
    }
    public void set(double x, double y){
        this.aX = x;
        this.aY = y;
    }
    public Vector2D add(Vector2D v){
        return new Vector2D(this.aX + v.aX, this.aY + v.aY);
    }
    public Vector2D sub(Vector2D v){
        return new Vector2D(this.aX - v.aX, this.aY - v.aY);
    }
    public String toString(){
        return String.valueOf(aX) + ":" + String.valueOf(aY);
    }

}
