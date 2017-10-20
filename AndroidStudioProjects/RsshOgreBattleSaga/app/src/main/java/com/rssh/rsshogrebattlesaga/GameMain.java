package com.rssh.rsshogrebattlesaga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by araumi on 2017/10/12.
 */

public class GameMain extends View {
    protected double aRateW;
    protected double aRateH;
    private Cockpit aCockpit;
    private float aX;
    private Vector3D aVec;
    private ScaleGestureDetector aScaleGesture;
    public GameMain(Context context) {
        super(context);
        Global g = Global.getInstance();
        aRateW = g.getWidthRate();
        aRateH = g.getHeightRate();
        aCockpit = new Cockpit();
        aVec = new Vector3D(10, 0, 0);
        aX = 0;

        aScaleGesture = new ScaleGestureDetector(context, scaleGestureListener);
    }
    public void update(){
        if(aX >= 1000 - 30 || aX < 0){
            aVec.aX *= -1;
        }
        aX += aVec.aX;
        aCockpit.update();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aCockpit.draw(canvas);
        Paint p = new Paint();
        p.setColor(Color.RED);
        canvas.drawRect((float)calcX(aX), (float)calcY(0), (float)calcX(aX + 30), (float)calcY(30), p);
    }
    public double calcX(double x){return x * aRateW;}
    public double calcY(double y){return y * aRateH;}

    private ScaleGestureDetector.SimpleOnScaleGestureListener scaleGestureListener = new ScaleGestureDetector.SimpleOnScaleGestureListener(){
        public boolean onScaleBegin(ScaleGestureDetector detector){
            Log.d("gamemain", "scale");
            aX = 0;
            return super.onScaleBegin(detector);
        }
    };
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        aScaleGesture.onTouchEvent(event);

        return super.onTouchEvent(event);
    }
}
