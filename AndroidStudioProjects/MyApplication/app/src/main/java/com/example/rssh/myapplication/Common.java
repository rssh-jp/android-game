package com.example.rssh.myapplication;

/**
 * Created by rssh on 17/03/25.
 */

public class Common {
    public static double angle2Radian(double angle){
        return Math.PI * angle / 180;
    }
    public static double radian2Angle(double radian){
        return 180 * radian / Math.PI;
    }
}