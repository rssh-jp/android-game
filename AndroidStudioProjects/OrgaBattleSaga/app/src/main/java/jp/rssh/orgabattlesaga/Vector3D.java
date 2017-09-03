package jp.rssh.orgabattlesaga;

/**
 * Created by t-araumi on 2017/09/03.
 */

public class Vector3D {
    public double aX, aY, aZ;
    public Vector3D(double x, double y, double z){
        this.set(x, y, z);
    }
    public void set(double x, double y, double z){
        aX = x;
        aY = y;
        aZ = z;
    }
    public Vector3D clone(){
        return new Vector3D(this.aX, this.aY, this.aZ);
    }
    public double[] toArray(){
        double d[] = {this.aX, this.aY, this.aZ};
        return d;
    }
    public double[] toArrayInverse(){
        double d[] = {-this.aX, -this.aY, -this.aZ};
        return d;
    }
    public Vector3D add(Vector3D v){
        return new Vector3D(this.aX + v.aX, this.aY + v.aY, this.aZ + v.aZ);
    }
    public Vector3D sub(Vector3D v){
        return new Vector3D(this.aX - v.aX, this.aY - v.aY, this.aZ - v.aZ);
    }
    public Vector3D mul(double num){
        return new Vector3D(this.aX * num, this.aY * num, this.aZ * num);
    }
    public Vector3D div(double num){
        return new Vector3D(this.aX / num, this.aY / num, this.aZ / num);
    }
    public double length(){
        return Math.sqrt((this.aX * this.aX) + (this.aY * this.aY) + (this.aZ * this.aZ));
    }
    public Vector3D normalize(){
        return this.div(this.length());
    }
    public double dot(Vector3D v){
        return (this.aX * v.aX) + (this.aY * v.aY) + (this.aZ * v.aZ);
    }
    public Vector3D cross(Vector3D v){
        return new Vector3D((this.aY * v.aZ) - (this.aZ * v.aY), (this.aX * v.aZ) - (this.aZ * v.aX), (this.aX * v.aY) - (this.aY * v.aX));
    }
}
