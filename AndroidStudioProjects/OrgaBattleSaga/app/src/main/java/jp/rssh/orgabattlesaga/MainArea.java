package jp.rssh.orgabattlesaga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * Created by t-araumi on 2017/09/03.
 */

public class MainArea extends RelativeLayout {
    WorldMap aWorldMap;
    Unit aUnit;
    Unit aEnemyUnit;

    boolean aIsTouched;
    Vector2D aTouchPoint;


    public MainArea(Context context){
        super(context);
        this.setBackgroundColor(Color.GREEN);

        aIsTouched = false;
        aTouchPoint = new Vector2D(0, 0);

        aWorldMap = new WorldMap(context);
        this.addView(aWorldMap);

        aUnit = new Unit(context, Color.BLUE);
        aUnit.setTranslationX(100);
        aUnit.setTranslationY(100);
        this.addView(aUnit);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        aWorldMap.invalidate();
        aUnit.invalidate();
    }

    public float getAreaWidth(){
        return aWorldMap.getWidth();
    }
    public float getAreaHeight(){
        return aWorldMap.getHeight();
    }

    public void update(){
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MainArea", "onTouchEvent");
//        switch(event.getAction()){
//        case MotionEvent.ACTION_DOWN:
//            aIsTouched = true;
//            aTouchPoint.set(event.getX(), event.getY());
//            return true;
//        case MotionEvent.ACTION_UP:
//            aIsTouched = false;
//            return true;
//        case MotionEvent.ACTION_MOVE:
//            if(!aIsTouched){
//                break;
//            }
//            Vector2D current = new Vector2D(event.getX(), event.getY());
//            current = current.sub(aTouchPoint);
//            float newX = this.getX() + (float)current.aX;
//            float newY = this.getY() + (float)current.aY;
//
//            Global g = Global.getInstance();
//            int w = g.getDisplayWidth();
//            int h = g.getDisplayHeight();
//            newX = newX > 0 ? 0 : newX;
//            newY = newY > 0 ? 0 : newY;
//            newX = newX < -(this.getAreaWidth() - w) ? -(this.getAreaWidth() - w) : newX;
//            newY = newY < -(this.getAreaHeight() - h) ? -(this.getAreaHeight() - h) : newY;
//            this.setTranslationX(newX);
//            this.setTranslationY(newY);
//
//            Log.d("screen", String.valueOf(w) + ":" + String.valueOf(h));
//            Log.d("point", String.valueOf(newX) + ":" + String.valueOf(newY));
//
//            aTouchPoint.set(event.getX(), event.getY());
//
//            return true;
//        case MotionEvent.ACTION_CANCEL:
//            break;
//        }
        return super.onTouchEvent(event);
    }
}
