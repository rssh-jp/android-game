package com.rssh.rsshogrebattlesaga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by araumi on 2017/10/12.
 */

public class GameMain extends View {
    protected double aRateW;
    protected double aRateH;
    private ScaleGestureDetector aScaleGesture;
    private String aEventId;

    public eState aState;

    private enum eState{
        FieldInit,
        Field,
        Map,
        MapInit,
        Setting,
        SettiongInit,
    }

    private DrawBase aMainDisplay;
    private DrawBase aCockpitDisplay;

    public GameMain(Context context) {
        super(context);
        Global g = Global.getInstance();
        aRateW = g.getWidthRate();
        aRateH = g.getHeightRate();
        aEventId = "";

        aState = eState.FieldInit;

        aMainDisplay = null;
        aCockpitDisplay = null;

    }
    public void update(){
        switch(aState){
        case FieldInit:
            aMainDisplay = new FieldMain("display", 0, 0);
            aCockpitDisplay = new FieldCockpit("cockpit", 0, 1000);
            aState = eState.Field;
            break;
        case Field:
            aMainDisplay.update();
            aCockpitDisplay.update();
            break;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(aMainDisplay != null){
            aMainDisplay.draw(canvas);
        }
        if(aCockpitDisplay != null){
            aCockpitDisplay.draw(canvas);
        }
        super.onDraw(canvas);

    }
    public double calcX(double x){return x * aRateW;}
    public double calcY(double y){return y * aRateH;}

/*
    private ScaleGestureDetector.SimpleOnScaleGestureListener scaleGestureListener = new ScaleGestureDetector.SimpleOnScaleGestureListener(){
        public boolean onScaleBegin(ScaleGestureDetector detector){
            Log.d("gamemain", "scale");
            aX = 0;
            return super.onScaleBegin(detector);
        }
    };
*/
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 前タッチイベント
        if(aMainDisplay != null){
            ResTouchEvent res = aMainDisplay.preTouchEvent(event, 0, 0, aEventId);
            if(res.aResult){
                aEventId = res.aId;
                return true;
            }
        }
        if(aCockpitDisplay != null){
            Log.d("aaaaaa", "aaaaaaaaaaaaa");
            ResTouchEvent res = aCockpitDisplay.preTouchEvent(event, 0, 0, aEventId);
            if(res.aResult){
                aEventId = res.aId;
                return true;
            }
        }
        // execute

        // 後タッチイベント
        if(aMainDisplay != null){
            ResTouchEvent res = aMainDisplay.postTouchEvent(event, 0, 0, aEventId);
            if(res.aResult){
                aEventId = res.aId;
                return true;
            }
        }
        if(aCockpitDisplay != null){
            ResTouchEvent res = aCockpitDisplay.postTouchEvent(event, 0, 0, aEventId);
            if(res.aResult){
                aEventId = res.aId;
                return true;
            }
        }

        return super.onTouchEvent(event);
    }
}
