package com.example.rssh.myapplication;


/**
 * Created by araumi on 2017/02/28.
 */

public class Vector3 {
    public double aX, aY, aZ;
    public Vector3(double x, double y, double z){
        this.set(x, y, z);
    }
    public void set(double x, double y, double z){
        aX = x;
        aY = y;
        aZ = z;
    }
    public Vector3 clone(){
        return new Vector3(this.aX, this.aY, this.aZ);
    }
    public double[] toArray(){
        double d[] = {this.aX, this.aY, this.aZ};
        return d;
    }
    public double[] toArrayInverse(){
        double d[] = {-this.aX, -this.aY, -this.aZ};
        return d;
    }
    public Vector3 add(Vector3 v){
        return new Vector3(this.aX + v.aX, this.aY + v.aY, this.aZ + v.aZ);
    }
    public Vector3 sub(Vector3 v){
        return new Vector3(this.aX - v.aX, this.aY - v.aY, this.aZ - v.aZ);
    }
    public Vector3 mul(double num){
        return new Vector3(this.aX * num, this.aY * num, this.aZ * num);
    }
    public Vector3 div(double num){
        return new Vector3(this.aX / num, this.aY / num, this.aZ / num);
    }
    public double length(){
        return Math.sqrt((this.aX * this.aX) + (this.aY * this.aY) + (this.aZ * this.aZ));
    }
    public Vector3 normalize(){
        return this.div(this.length());
    }
    public double dot(Vector3 v){
        return (this.aX * v.aX) + (this.aY * v.aY) + (this.aZ * v.aZ);
    }
    public Vector3 cross(Vector3 v){
        return new Vector3((this.aY * v.aZ) - (this.aZ * v.aY), (this.aX * v.aZ) - (this.aZ * v.aX), (this.aX * v.aY) - (this.aY * v.aX));
    }
}
