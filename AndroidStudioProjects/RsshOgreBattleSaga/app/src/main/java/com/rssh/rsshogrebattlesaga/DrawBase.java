package com.rssh.rsshogrebattlesaga;

import android.graphics.Canvas;

/**
 * Created by araumi on 2017/10/12.
 */

public class DrawBase {
    protected Vector3D aPos;
    protected double aRateW;
    protected double aRateH;
    public DrawBase(){
        aPos = new Vector3D();
        Global g = Global.getInstance();
        aRateW = g.getWidthRate();
        aRateH = g.getHeightRate();
    }
    public void draw(Canvas c){
    }
    public void update(){}
    public double calcX(double x){return x * aRateW;}
    public double calcY(double y){return y * aRateH;}
}
