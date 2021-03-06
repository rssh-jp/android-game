package com.rssh.rsshogrebattlesaga;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by araumi on 2017/10/12.
 */

public class DrawBase {
    protected String aId;
    protected Vector3D aPos;
    protected double aRateW;
    protected double aRateH;
    public DrawBase(String id, double x, double y){
        aId = id;
        aPos = new Vector3D(x, y, 0);
        Global g = Global.getInstance();
        aRateW = g.getWidthRate();
        aRateH = g.getHeightRate();
    }
    private String getClassName(){
//        new Object(){}.getClass().getName();
        //return new Object(){}.getClass().getEnclosingClass().getName();
        return DrawBase.class.getName().toString();
    }
    protected void trace(double x, double y){
        Log.d(getClassName(), String.valueOf(x) + ":" + String.valueOf(y));
    }
    protected void trace(String s){
        Log.d(getClassName(), s);
    }
    public void setPos(double x, double y){
        aPos.aX = x;
        aPos.aY = y;
    }
    public void setPos(Vector3D p){
        aPos.aX = p.aX;
        aPos.aY = p.aY;
    }
    public double getX(){return aPos.aX;}
    public double getY(){return aPos.aY;}
    public boolean checkId(String id){return aId == id;}
    public double calcX(double x){return x * aRateW;}
    public double calcY(double y){return y * aRateH;}

    public void draw(Canvas c){
    }
    public void update(){
    }
    public ResTouchEvent preTouchEvent(MotionEvent event, float x, float y, String id){
        if(!checkId(id)){
            return new ResTouchEvent();
        }
        trace(event.getX(), event.getY());
        trace(getX() + x, getY() + y);
        return new ResTouchEvent();
    }
    public ResTouchEvent postTouchEvent(MotionEvent event, float x, float y, String id){
        if(!checkId(id)){
            return new ResTouchEvent();
        }
        trace(event.getX(), event.getY());
        trace(getX() + x, getY() + y);
        return new ResTouchEvent();
    }
}
