package com.rssh.rsshogrebattlesaga;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by araumi on 2017/11/24.
 */

public class Button extends DrawBase{
    public double aX, aY, aW, aH;
    public Paint aPaint;
    public boolean aIsTouch;
    public Button(String id, double x, double y, double w, double h, Vector3D p){
        super(id, p.aX, p.aY);
        aX = x;
        aY = y;
        aW = w;
        aH = h;
        aPaint = new Paint();
        aPaint.setColor(Color.BLUE);
        aIsTouch = false;
    }
    public void draw(Canvas c){
        if(aIsTouch){
            aPaint.setColor(Color.GREEN);
        }else{
            aPaint.setColor(Color.BLUE);
        }
        c.drawRect((float)calcX(aPos.aX + aX), (float)calcY(aPos.aY + aY), (float)calcX(aPos.aX + aX + aW), (float)calcY(aPos.aY + aY + aH), aPaint);
    }
    public ResTouchEvent preTouchEvent(MotionEvent event, float x, float y, String id){
        float wkx = (float)calcX(aPos.aX + aX);
        float wky = (float)calcY(aPos.aY + aY);
        float wkw = (float)calcX(aPos.aX + aX + aW);
        float wkh = (float)calcY(aPos.aY + aY + aH);
        float gx = event.getX();
        float gy = event.getY();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(wkx <= gx && wkw >= gx && wky <= gy && wkh >= gy) {
                    aIsTouch = true;
                    return new ResTouchEvent(aId, true);
                }
                break;
        }

        if(!checkId(id)){
            return new ResTouchEvent();
        }

        switch(event.getAction()){
            case MotionEvent.ACTION_MOVE:
                if(wkx <= gx && wkw >= gx && wky <= gy && wkh >= gy) {
                    aIsTouch = true;
                }else{
                    aIsTouch = false;
                }
                return new ResTouchEvent(aId, true);
            case MotionEvent.ACTION_UP:
                aIsTouch = false;
                return new ResTouchEvent(aId, true);
        }
        return new ResTouchEvent();
    }
}

