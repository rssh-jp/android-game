package jp.rssh.orgabattlesaga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.RelativeLayout;

/**
 * Created by t-araumi on 2017/09/10.
 */

public class Cockpit extends RelativeLayout {
    private Paint aPaint;
    public Cockpit(Context context){
        super(context);
        aPaint = new Paint();
        aPaint.setColor(Color.GREEN);
        aPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, 500, 500, aPaint);
    }
}
