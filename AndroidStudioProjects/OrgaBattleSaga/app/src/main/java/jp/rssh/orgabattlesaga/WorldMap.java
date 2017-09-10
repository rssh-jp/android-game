package jp.rssh.orgabattlesaga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by t-araumi on 2017/09/03.
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
        canvas.drawRect(0, 0, 2000, 2000, aPaint);
    }
}
