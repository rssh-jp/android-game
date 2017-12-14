package com.rssh.rsshogrebattlesaga;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by araumi on 2017/10/12.
 */

public class FieldCockpit extends DrawBase{
    protected Paint aPaint;
    protected double aWidth;
    protected double aHeight;

    protected Button aButton;
    /**
     * コンストラクタ
     * 一意のidを与えることで、イベント発生時にこのオブジェクト以外のイベントを抑制する
     * @param  id id
     **/
    public FieldCockpit(String id, double x, double y){
        super(id, x, y);
        Global g = Global.getInstance();
        aWidth = 1000;
        aHeight = 1000;
        aPaint = new Paint();
        aPaint.setColor(Color.RED);
        trace(aRateW, aRateH);
        aButton = new Button("b", 500, 500, 100, 100, aPos);
    }

    /**
     * 描画
     * @param c
     */
    public void draw(Canvas c){
        c.drawRect((float)calcX(aPos.aX), (float)calcY(aPos.aY), (float)calcX(aPos.aX + aWidth), (float)calcY(aPos.aY + aHeight), aPaint);
        aButton.draw(c);
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        c.drawRect((float)calcX(100 + aPos.aX), (float)calcY(100 + aPos.aY), (float)calcX(200 + aPos.aX), (float)calcY(200 + aPos.aY), p);
    }

    /**
     * 前イベント
     * updateの前に呼ばれるイベント
     * @param event
     * @param x
     * @param y
     * @param id
     * @return
     */
    public ResTouchEvent preTouchEvent(MotionEvent event, float x, float y, String id){
        ResTouchEvent res = aButton.preTouchEvent(event, x, y, id);
        if(res.aResult){
            return res;
        }
        if(!checkId(id)){
            return new ResTouchEvent();
        }

        return new ResTouchEvent();
    }
}
