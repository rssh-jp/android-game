package jp.rssh.orgabattlesaga;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by araumi on 2017/09/28.
 */

public class BaseView extends View {
    public BaseView(Context context){
        super(context);
    }

    private String getClassName(){
//        new Object(){}.getClass().getName();
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

    public boolean preTouchEvent(MotionEvent event, float x, float y){
        trace(event.getX(), event.getY());
        trace(this.getX() + x, this.getY() + y);
        return false;
    }

    public boolean postTouchEvent(MotionEvent event, float x, float y){
        trace(event.getX(), event.getY());
        trace(this.getX() + x, this.getY() + y);
        return false;
    }
}
