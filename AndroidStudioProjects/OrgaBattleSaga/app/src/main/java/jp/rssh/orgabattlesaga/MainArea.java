package jp.rssh.orgabattlesaga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
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
        return super.onTouchEvent(event);
    }
}
