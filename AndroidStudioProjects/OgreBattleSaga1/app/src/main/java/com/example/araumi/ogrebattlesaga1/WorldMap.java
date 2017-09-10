package com.example.araumi.ogrebattlesaga1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by araumi on 西暦 2017/8/31.
 */

public class WorldMap extends View {
    Paint aPaint;
    public WorldMap(Context context){
        super(context);
        aPaint = new Paint();
        aPaint.setColor(Color.RED);
        aPaint.setStyle(Paint.Style.FILL);
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(0, 0, 100, 100, aPaint);
    }
}
