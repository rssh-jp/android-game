package jp.rssh.orgabattlesaga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by t-araumi on 2017/09/03.
 */

public class MainArea extends RelativeLayout {
    WorldMap aWorldMap;
    Unit aUnit[];

    boolean aIsTouched;
    Vector2D aTouchPoint;

    public MainArea(Context context){
        super(context);
        this.setBackgroundColor(Color.GREEN);

        aIsTouched = false;
        aTouchPoint = new Vector2D(0, 0);

        aWorldMap = new WorldMap(context);
        this.addView(aWorldMap);

        aUnit = new Unit[2];
        for(int i=0; i<2; i++){
            aUnit[i] = new Unit(context, Color.BLUE, i, this);
            aUnit[i].setTranslationX((i * 400) + 100);
            aUnit[i].setTranslationY((i * 400) + 100);
            this.addView(aUnit[i]);
        }
    }

    public void checkUnit(int number){
        for(int i=0; i<2; i++){
            if(number == i){
                continue;
            }
            aUnit[i].aIsSelected = false;
            aUnit[i].invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        aWorldMap.invalidate();

        for(int i=0; i<2; i++){
            aUnit[i].invalidate();
        }
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
