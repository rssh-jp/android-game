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
    MainArea aParent;
    int aNumber;

    public Unit(Context context, int color, int number, MainArea parent){
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

        aParent = parent;
        aNumber = number;
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(0, 0, 50, 50, aPaint);
        if(!aIsSelected) {
            return;
        }
        canvas.drawRect(0, 0, 50, 50, aSelectPaint);
    }

/*
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Unit", "onTouchEvent");
        switch(event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            Log.d("down", String.valueOf(event.getX()) + ":" + String.valueOf(event.getY()));
            if(event.getX() > 50 || event.getX() < 0 || event.getY() > 50 || event.getY() < 0){
                break;
            }
            Log.d("down", "success");
            aIsTouched = true;
            return true;
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
            this.invalidate();
            aParent.checkUnit(aNumber);

            return true;
        }
        return super.onTouchEvent(event);
    }
*/

    private String getClassName(){
        return new Object(){}.getClass().getEnclosingClass().getName();
    }
    private void trace(double x, double y){
        Log.d(getClassName(), String.valueOf(x) + ":" + String.valueOf(y));
    }
    private void trace(){
        Log.d(getClassName(), "");
    }
    private void trace(String str){
        Log.d(getClassName(), str);
    }

    public float getX(float x){return super.getX() + x;}
    public float getY(float y){return super.getY() + y;}

    private float eventGetX(MotionEvent event, float x){return event.getX() - (super.getX() + x);}
    private float eventGetY(MotionEvent event, float y){return event.getY() - (super.getY() + y);}

    public ResTouchEvent preTouchEvent(MotionEvent event, float x, float y, int id){
        if(id != 0 && id != this.getId()){
            return new ResTouchEvent();
        }
        trace(event.getX(), event.getY());
        trace(this.getX(x), this.getY(y));
        trace(eventGetX(event, x), eventGetY(event, y));
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("down", String.valueOf(event.getX()) + ":" + String.valueOf(event.getY()));
                if(eventGetX(event, x) > 50 || eventGetX(event, x) < 0 || eventGetY(event, y) > 50 || eventGetY(event, y) < 0){
                    break;
                }
                Log.d("down", "success");
                aIsTouched = true;
                return new ResTouchEvent(this.getId(), true);
            case MotionEvent.ACTION_UP:
                Log.d("up", String.valueOf(event.getX()) + ":" + String.valueOf(event.getY()));
                if(eventGetX(event, x) > 50 || eventGetX(event, x) < 0 || eventGetY(event, y) > 50 || eventGetY(event, y) < 0){
                    aIsTouched = false;
                    break;
                }
                if(!aIsTouched){
                    break;
                }
                Log.d("up", "success");
                aIsTouched = false;
                aIsSelected = true;
                this.invalidate();
                aParent.checkUnit(aNumber);

                return new ResTouchEvent(this.getId(), true);
        }
        return new ResTouchEvent();
    }

    public ResTouchEvent postTouchEvent(MotionEvent event, float x, float y, int id){
        if(id != 0 && id != this.getId()){
            return new ResTouchEvent();
        }
        trace(event.getX(), event.getY());
        trace(this.getX() + x, this.getY() + y);
        return new ResTouchEvent();
    }
}
