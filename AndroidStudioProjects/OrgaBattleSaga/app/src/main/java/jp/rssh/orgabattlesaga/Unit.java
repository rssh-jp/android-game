package jp.rssh.orgabattlesaga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by t-araumi on 2017/09/03.
 */

public class Unit extends View {
    Paint aPaint;
    Paint aSelectPaint;
    boolean aIsTouched;
    boolean aIsSelected;
    public Unit(Context context, int color){
        super(context);
        aIsTouched = false;
        aIsSelected = false;
        aPaint = new Paint();
        aPaint.setColor(color);
        aPaint.setStyle(Paint.Style.FILL);
        aSelectPaint = new Paint();
        aSelectPaint.setColor(Color.GRAY);
        aSelectPaint.setStrokeWidth(5);
        aSelectPaint.setStyle(Paint.Style.STROKE);
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(0, 0, 50, 50, aPaint);
        if(!aIsSelected) {
            return;
        }
        canvas.drawRect(0, 0, 50, 50, aSelectPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("down", String.valueOf(event.getX()) + ":" + String.valueOf(event.getY()));
                if(event.getX() > 50 || event.getX() < 0 || event.getY() > 50 || event.getY() < 0){
                    break;
                }
                Log.d("down", "success");
                aIsTouched = true;
                break;
            case MotionEvent.ACTION_UP:
                Log.d("up", String.valueOf(event.getX()) + ":" + String.valueOf(event.getY()));
                if(event.getX() > 50 || event.getX() < 0 || event.getY() > 50 || event.getY() < 0){
                    aIsTouched = false;
                    break;
                }
                if(!aIsTouched){
                    break;
                }
                Log.d("up", "success");
                aIsTouched = false;
                aIsSelected = true;

                break;
        }
        return false;
        //return super.onTouchEvent(event);
    }
}
