package com.example.rssh.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by rssh on 17/02/21.
 */

public class Ball extends View {
    int x, y, radius;
    int prevX, prevY;
    Paint paint;
    int vx, vy;

    public Ball(Context context, int _vx, int _vy) {
        super(context);
        radius = 30;
        x = y = 0;
        vx = _vx;
        vy = _vy;
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawCircle(x, y, radius, paint);
    }
    public void update(int _x, int _y, int _w, int _h){
        prevX = x;
        prevY = y;
        x += vx;
        y += vy;

        if(_x > x - radius){
            x = _x + radius;
            vx = -vx;
        }
        else if(_x + _w <= x + radius){
            x = _x + _w - radius;
            vx = -vx;
        }
        if(_y > y - radius) {
            y = _y + radius;
            vy = -vy;
        }
        else if(_y + _h <= y + radius){
            y = _y + _h - radius;
            vy = -vy;
        }
    }
}