package jp.rssh.orgabattlesaga;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity implements Runnable {

    int cUpdateTime = 16;

    Handler aHandler;

    int aWidth, aHeight;

    MainArea aMainArea;

    boolean aIsTouched;
    Vector2D aTouchPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aIsTouched = false;
        aTouchPoint = new Vector2D(0, 0);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        WindowManager windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        aWidth = point.x;
        aHeight = point.y;

        aHandler = new Handler();
        aHandler.postDelayed(this, cUpdateTime);

        aMainArea = new MainArea(this);
        setContentView(aMainArea);
        aMainArea.getLayoutParams().width = 2000;
        aMainArea.getLayoutParams().height = 2000;
        aMainArea.requestLayout();
    }
    public void run(){
        aMainArea.update();
        aHandler.postDelayed(this, cUpdateTime);
    }
    public void onDestroy(){
        super.onDestroy();
        aHandler.removeCallbacks(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
        case MotionEvent.ACTION_DOWN:
            aIsTouched = true;
            aTouchPoint.set(event.getX(), event.getY());
            break;
        case MotionEvent.ACTION_UP:
            aIsTouched = false;
            break;
        case MotionEvent.ACTION_MOVE:
            if(!aIsTouched){
                break;
            }
            Vector2D current = new Vector2D(event.getX(), event.getY());
            current = current.sub(aTouchPoint);
            float newX = aMainArea.getX() + (float)current.aX;
            float newY = aMainArea.getY() + (float)current.aY;

            newX = newX > 0 ? 0 : newX;
            newY = newY > 0 ? 0 : newY;
            newX = newX < -(aMainArea.getAreaWidth() - aWidth) ? -(aMainArea.getAreaWidth() - aWidth) : newX;
            newY = newY < -(aMainArea.getAreaHeight() - aHeight) ? -(aMainArea.getAreaHeight() - aHeight) : newY;
            aMainArea.setTranslationX(newX);
            aMainArea.setTranslationY(newY);

            aTouchPoint.set(event.getX(), event.getY());


            break;
        case MotionEvent.ACTION_CANCEL:
            break;
        }

        aMainArea.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
