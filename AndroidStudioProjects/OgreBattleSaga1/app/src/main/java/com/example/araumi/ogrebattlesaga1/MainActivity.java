package com.example.araumi.ogrebattlesaga1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements Runnable {

    int cUpdateTime = 16;

    Handler aHandler;
    RelativeLayout aRelativeLayout;

    WorldMap aWorldMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        aHandler = new Handler();
        aHandler.postDelayed(this, cUpdateTime);

        aRelativeLayout = new RelativeLayout(this);
        aRelativeLayout.setBackgroundColor(Color.GREEN);
        setContentView(aRelativeLayout);

        aWorldMap = new WorldMap(this);
        aRelativeLayout.addView(aWorldMap);


    }
    public void run(){
        aHandler.postDelayed(this, cUpdateTime);
    }
    public void onDestroy(){
        super.onDestroy();
        aHandler.removeCallbacks(this);
    }
}
