package com.rssh.rsshogrebattlesaga;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by araumi on 2017/10/19.
 */

public class FieldMain extends DrawBase{
    private float aX;
    private Vector3D aVec;
    public FieldMain(String id, double x, double y){
        super(id, x, y);
        aVec = new Vector3D(10, 0, 0);
        aX = 0;
    }
    public void update(){
        if(aX >= 1000 - 30 || aX < 0){
            aVec.aX *= -1;
        }
        aX += aVec.aX;
    }
    public void draw(Canvas c){
        Paint p = new Paint();
        p.setColor(Color.RED);
        c.drawRect((float)calcX(aX), (float)calcY(0), (float)calcX(aX + 30), (float)calcY(30), p);
    }
}
