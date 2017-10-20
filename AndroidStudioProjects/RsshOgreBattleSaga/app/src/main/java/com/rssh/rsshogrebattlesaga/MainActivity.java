package com.rssh.rsshogrebattlesaga;

import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements Runnable{

    private static final int cUpdateTime = 16;

    private GameMain aGameMain;

    private Handler aHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        WindowManager windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        Global g = Global.getInstance();
        g.setDisplaySize(point.x, point.y);
        Log.d("activity", String.valueOf(point.x) + String.valueOf(point.y));

        aGameMain = new GameMain(this);
        setContentView(aGameMain);

        aHandler = new Handler();
        aHandler.postDelayed(this, cUpdateTime);
    }

    @Override
    public void run() {
        aGameMain.update();
        aGameMain.invalidate();
        aHandler.postDelayed(this, cUpdateTime);
    }
}
