package com.example.rssh.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by rssh on 17/02/21.
 */

public class Ball extends View {
    Vector3 aDir;
    Vector3 aPos;
    Vector3 aPrevPos;
    double aSpeed;
    int radius;
    Paint paint;
    Bitmap aBitmap;
    Bitmap aDisplay;
    int aPixels[];
    int aWidth, aHeight;

    public Ball(Context context, int _vx, int _vy, int w, int h) {
        super(context);
        aWidth = w;
        aHeight = h;
        radius = 30;
        aPos = new Vector3(200, 600, 0);
        aPrevPos = new Vector3(0, 0, 0);
        int angle = 100;
        double speed = 10;
        aSpeed = speed;
        double rad = Common.angle2Radian(angle);
        aDir = new Vector3(Math.cos(rad), Math.sin(rad), 0);
        aDir = aDir.normalize();
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        aBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
        aBitmap = aBitmap.createScaledBitmap(aBitmap, 60, 60, true);

        aDisplay = Bitmap.createBitmap(w + 60, h + 60, Bitmap.Config.ARGB_8888);
        aPixels = new int[60 * 60];
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

//        {
//            int p[] = new int[(aWidth + 60) * (aHeight + 60)];
//            aDisplay.getPixels(p, 0, aWidth + 60, 0, 0, aWidth + 60, aHeight + 60);
//            for(int i=0; i<aHeight + 60; i++) {
//                for(int k=0; k<aWidth + 60; k++){
//                    int c = p[k + (i * (aWidth + 60))];
//                    int a = c >>> 24;
//                    a -= 1;
//                    if(a < 0){
//                        a = 0;
//                    }
//                    a = a << 24;
//
//                    c = c << 8;
//                    c = c >>> 8;
//                    p[k + (i * (aWidth + 60))] = a ^ c;
//                }
//            }
//            aDisplay.setPixels(p, 0, aWidth + 60, 0, 0, aWidth + 60, aHeight + 60);
//        }

//        aBitmap.getPixels(aPixels, 0, 60, 0, 0, 60, 60);
//        aDisplay.setPixels(aPixels, 0, 60, x, y, 60, 60);
//        canvas.drawBitmap(aDisplay, -30, -30, paint);
        canvas.drawBitmap(aBitmap, (int)aPos.aX - 30, (int)aPos.aY - 30, paint);
//        canvas.drawCircle(x, y, radius, paint);
    }
    public void update(int _x, int _y, int _w, int _h){
        aPrevPos = aPos.clone();
        aPos = aPos.add(aDir.mul(aSpeed));

        if(_x > aPos.aX - radius){
            aPos.aX = _x + radius;
            aDir.aX *= -1;
        }
        else if(_x + _w <= aPos.aX + radius){
            aPos.aX = _x + _w - radius;
            aDir.aX *= -1;
        }
        if(_y > aPos.aY - radius) {
            aPos.aY = _y + radius;
            aDir.aY *= -1;
        }
        else if(_y + _h <= aPos.aY + radius){
            aPos.aY = _y + _h - radius;
            aDir.aY *= -1;
        }
    }
    public int X(){
        return (int)aPos.aX;
    }
    public int Y(){
        return (int)aPos.aY;
    }
    public int PrevX(){
        return (int)aPrevPos.aX;
    }
    public int PrevY(){
        return (int)aPrevPos.aY;
    }
    public void reverseX(){
        aDir.aX *= -1;
    }
    public void reverseY(){
        aDir.aY *= -1;
    }
}