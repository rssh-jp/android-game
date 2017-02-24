package com.example.rssh.myapplication;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by araumi on 2017/02/23.
 */

public class Test3dView extends GLSurfaceView{
    Test3dRenderer renderer;
    public Test3dView(Context context){
        super(context);
        renderer = new Test3dRenderer();
        setRenderer(renderer);
    }
}
