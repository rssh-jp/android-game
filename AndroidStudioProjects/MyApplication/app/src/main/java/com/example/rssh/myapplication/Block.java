package com.example.rssh.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by araumi on 2017/02/22.
 */

public class Block extends View{
    int x, y, w, h;
    boolean isValid;
    enum DIR{
        NONE,
        LEFT,
        TOP,
        RIGHT,
        DOWN,
    }

    public Block(Context context, int _x, int _y) {
        super(context);
        x = _x;
        y = _y;
        w = 100;
        h = 60;
        isValid = true;
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(x, y, x + w, y + h, paint);

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(x + 10, y + 10, x + w - 10, y + h - 10, paint);

    }

    public boolean isCollisionSphere(int _x, int _y, int radius){
        if(
                (x < _x && x + w >= _x)
                && (y <_y && y + h >= _y)
        ){
            return true;
        }
        return false;
    }
    public DIR collisionSphereDirection(int _x, int _y, int old_x, int old_y, int radius){
        if(!
                (x < _x && x + w >= _x)
                        && (y <_y && y + h >= _y)
                ){
            return DIR.NONE;
        }
        if(old_x < x){
            return DIR.LEFT;
        }
        else if(old_x > x + w){
            return DIR.RIGHT;
        }
        else if(old_y < y){
            return DIR.DOWN;
        }
        else if(old_y > y + h){
            return DIR.TOP;
        }


        return DIR.NONE;
    }
}
