package com.rssh.rsshogrebattlesaga;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by araumi on 2017/10/12.
 */

public class Cockpit extends DrawBase{
    protected Paint aPaint;
    protected double aWidth;
    protected double aHeight;
    private void trace(double x, double y){
        Log.d("cockpit", String.valueOf(x) + ":" + String.valueOf(y));
    }
    public Cockpit(String id){
        super(id);
        Global g = Global.getInstance();
        aWidth = 1000;
        aHeight = 1000;
        aPaint = new Paint();
        aPaint.setColor(Color.RED);
        trace(aRateW, aRateH);
    }
    public void draw(Canvas c){
        c.drawRect((float)calcX(aPos.aX), (float)calcY(aPos.aY), (float)calcX(aPos.aX + aWidth), (float)calcY(aPos.aY + aHeight), aPaint);
    }
    public ResTouchEvent preTouchEvent(MotionEvent event, float x, float y, String id){
        if(!checkId(id)){
            return new ResTouchEvent();
        }
        trace(event.getX(), event.getY());
        trace(getX() + x, getY() + y);
        
        return new ResTouchEvent();
    }
}
