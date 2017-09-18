package jp.rssh.orgabattlesaga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by t-araumi on 2017/09/10.
 */

public class Cockpit extends ViewGroup {
    private Paint aPaint;
    public Cockpit(Context context){
        super(context);
        this.setBackgroundColor(Color.GREEN);
        aPaint = new Paint();
        aPaint.setColor(Color.MAGENTA);
        aPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, 100, 100, aPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
