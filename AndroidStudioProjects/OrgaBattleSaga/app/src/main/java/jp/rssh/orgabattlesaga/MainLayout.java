package jp.rssh.orgabattlesaga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by t-araumi on 2017/09/18.
 */

public class MainLayout extends RelativeLayout {
    int aWidth, aHeight;

    MainArea aMainArea;
    Cockpit aCockpit;

    boolean aIsTouched;
    Vector2D aTouchPoint;

    public MainLayout(Context context, int width, int height) {
        super(context);

        aWidth = width;
        aHeight = height;

        aIsTouched = false;
        aTouchPoint = new Vector2D(0, 0);

        this.setBackgroundColor(Color.GREEN);

        aMainArea = new MainArea(context);
        this.addView(aMainArea);
        aMainArea.requestLayout();

        aCockpit = new Cockpit(context);
        this.addView(aCockpit);
        aCockpit.setTranslationY(aHeight / 2);
        aCockpit.requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aMainArea.invalidate();
        aCockpit.invalidate();
    }

    public void update(){
        aMainArea.update();
    }

    private void trace(double x, double y){
        Log.d("mainLayout", String.valueOf(x) + ":" + String.valueOf(y));
    }
    private void trace(){
        Log.d("mainLayout", "");
    }
    private void trace(String str){
        Log.d("mainLayout", str);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        trace("touch");
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                aIsTouched = true;
                aTouchPoint.set(event.getX(), event.getY());
                return true;
            case MotionEvent.ACTION_UP:
                aIsTouched = false;
                break;
            case MotionEvent.ACTION_MOVE:
                if(!aIsTouched){
                    break;
                }
                trace("move");
                Vector2D current = new Vector2D(event.getX(), event.getY());
                current = current.sub(aTouchPoint);
                float newX = aMainArea.getX() + (float)current.aX;
                float newY = aMainArea.getY() + (float)current.aY;

                if(aWidth < aMainArea.getAreaWidth()){
                    newX = newX > 0 ? 0 : newX;
                    newX = newX < -(aMainArea.getAreaWidth() - aWidth) ? -(aMainArea.getAreaWidth() - aWidth) : newX;
                }
                else{
                    newX = 0;
                }
                if(aHeight < aMainArea.getAreaHeight()){
                    newY = newY > 0 ? 0 : newY;
                    newY = newY < -(aMainArea.getAreaHeight() - aHeight) ? -(aMainArea.getAreaHeight() - aHeight) : newY;
                }
                else {
                    newY = 0;
                }

                aMainArea.setTranslationX(newX);
                aMainArea.setTranslationY(newY);

                aTouchPoint.set(event.getX(), event.getY());

                return true;
            case MotionEvent.ACTION_CANCEL:
                break;
        }

        return super.onTouchEvent(event);
    }
}
