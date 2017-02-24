package com.example.rssh.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements Runnable {
    Ball ball;
    Block[] blocks;
    Handler handler;
    int width, height;
    int dx = 10, dy = 15, time = 16;

    RelativeLayout relativeLayout;

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
        ball = new Ball(this, 30, 30);
        ball.x = width / 2;
        ball.y = height / 2;
        relativeLayout.addView(ball);

        blocks = new Block[10];
        for(int i=0; i<10; i++){
            Block block = new Block(this, i * 100, 500);
            blocks[i] = block;
            relativeLayout.addView(blocks[i]);
        }
    }
    public void run() {
        ball.update(0, 0, width, height);
        for(int i=0; i<10; i++){
            if(!blocks[i].isValid){
                continue;
            }
            if(blocks[i].isCollisionSphere(ball.x, ball.y, ball.radius)){
                relativeLayout.removeView(blocks[i]);
                blocks[i].isValid = false;
                switch(blocks[i].collisionSphereDirection(ball.x, ball.y, ball.prevX, ball.prevY, ball.radius)){
                    case TOP:
                    case DOWN:
                        ball.vy = -ball.vy;
                        break;
                    case LEFT:
                    case RIGHT:
                        ball.vx = -ball.vx;
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
}
