package jp.rssh.orgabattlesaga;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity implements Runnable {

    int cUpdateTime = 16;

    Handler aHandler;

    MainLayout aMainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        WindowManager windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        aMainLayout = new MainLayout(this, point.x, point.y);
        setContentView(aMainLayout);
        aMainLayout.getLayoutParams().width = 2000;
        aMainLayout.getLayoutParams().height = 2000;

        aHandler = new Handler();
        aHandler.postDelayed(this, cUpdateTime);

    }
    public void run(){
        aMainLayout.update();
        aHandler.postDelayed(this, cUpdateTime);
    }
    public void onDestroy(){
        super.onDestroy();
        aHandler.removeCallbacks(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
