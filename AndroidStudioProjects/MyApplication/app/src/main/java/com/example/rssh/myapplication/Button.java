package com.example.rssh.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static android.R.attr.radius;
import static android.R.attr.x;
import static android.R.attr.y;

/**
 * Created by rssh on 17/02/28.
 */

public class Button extends View{
    int aX, aY, aRadius;
    Paint aPaint;
    boolean aIsPress;
    public Button(Context context, int x, int y, int r){
        super(context);
        aX = x;
        aY = y;
        aRadius = r;
        aPaint = new Paint();
        aPaint.setColor(Color.BLUE);
        aPaint.setStyle(Paint.Style.FILL);
        aIsPress = false;
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawCircle(aX, aY, aRadius, aPaint);
    }
    private boolean touchDown(MotionEvent e){
        if(this.aIsPress){
            return false;
        }
        Vector3 vTouch = new Vector3(e.getX(), e.getY(), 0);
        Vector3 vOwn = new Vector3(this.aX, this.aY, 0);
        if(vOwn.sub(vTouch).length() <= this.aRadius){
            this.aIsPress = true;
            aPaint.setColor(Color.RED);
            this.invalidate();
            Log.d("touch","button");
            return true;
        }

        return false;
    }
    private boolean touchUp(MotionEvent e){
        if(!this.aIsPress){
            return false;
        }
        aPaint.setColor(Color.BLUE);
        this.invalidate();
        Log.d("touch","button");
        this.aIsPress = false;
        return true;
    }
    public boolean onTouchEvent(MotionEvent e){
        switch(e.getAction()){
            case MotionEvent.ACTION_DOWN:
                return this.touchDown(e);
            case MotionEvent.ACTION_UP:
                return this.touchUp(e);
        }
        return false;
    }
}
