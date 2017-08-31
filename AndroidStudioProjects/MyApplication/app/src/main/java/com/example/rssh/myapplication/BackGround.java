package com.example.rssh.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by rssh on 17/03/07.
 */

public class BackGround extends View{
    Bitmap aBitmap;
    Paint aPaint;

    public BackGround(Context context, int w, int h){
        super(context);
        aBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image2);
        aPaint = new Paint();
        aPaint.setColor(Color.BLUE);
        aPaint.setStyle(Paint.Style.FILL);
        aBitmap = aBitmap.createScaledBitmap(aBitmap, w, h, true);
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(aBitmap, 0, 0, aPaint);
    }
}
