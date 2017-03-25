package com.example.rssh.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import java.io.File;

public class MainActivity extends Activity implements Runnable {
    Ball ball;
    Block[] blocks;
    Button aButton;
    BackGround aBG;
    Handler handler;
    int width, height;
    int dx = 10, dy = 15, time = 16;
    int blockNum = 100;

    RelativeLayout relativeLayout;

    Test3dView glView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.GREEN);
        setContentView(relativeLayout);

        handler = new Handler();
        handler.postDelayed(this, time);

        WindowManager windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        width = point.x;
        height = point.y;

        aBG = new BackGround(this, width, height);
        relativeLayout.addView(aBG);

        ball = new Ball(this, 10, 10, width, height);
        relativeLayout.addView(ball);

        blocks = new Block[blockNum];
        for(int i=0; i<blockNum; i++){
            int x =  40 + (100 * (i % 10));
            int y = 300 + ( 60 * (i / 10));
            Block block = new Block(this, x, y);
            blocks[i] = block;
            relativeLayout.addView(blocks[i]);
        }

        aButton = new Button(this, 200, 1300, 100);
        relativeLayout.addView(aButton);

        glView = new Test3dView(this);
//        setContentView(glView);

    }
    public void run() {
        ball.update(0, 0, width, height);
        for(int i=0; i<blockNum; i++){
            if(!blocks[i].isValid){
                continue;
            }
            if(blocks[i].isCollisionSphere(ball.X(), ball.Y(), ball.radius)){
                relativeLayout.removeView(blocks[i]);
                blocks[i].isValid = false;
                switch(blocks[i].collisionSphereDirection(ball.X(), ball.Y(), ball.PrevX(), ball.PrevY(), ball.radius)){
                    case TOP:
                    case DOWN:
                        ball.reverseY();
                        break;
                    case LEFT:
                    case RIGHT:
                        ball.reverseX();
                        break;
                }
            }
        }

        ball.invalidate();
        handler.postDelayed(this, time);
    }
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(this);
    }
    public boolean onTouchEvent(MotionEvent e){
        return false;

    }
}
