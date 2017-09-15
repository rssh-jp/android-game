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
}
