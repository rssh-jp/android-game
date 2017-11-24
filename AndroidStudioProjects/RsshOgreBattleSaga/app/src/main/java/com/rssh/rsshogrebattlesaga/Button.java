package com.rssh.rsshogrebattlesaga;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by araumi on 2017/11/24.
 */

public class Button extends DrawBase{
    public double aX, aY, aW, aH;
    public Paint aPaint;
    public Button(String id, double x, double y, double w, double h, Vector3D p){
        super(id, p.aX, p.aY);
        aX = x;
        aY = y;
        aW = w;
        aH = h;
        aPaint = new Paint();
        aPaint.setColor(Color.BLUE);
    }
    public void draw(Canvas c){
        c.drawRect((float)calcX(aPos.aX + aX), (float)calcY(aPos.aY + aY), (float)calcX(aPos.aX + aX + aW), (float)calcY(aPos.aY + aY + aH), aPaint);
    }
}

