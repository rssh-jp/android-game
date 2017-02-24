package com.example.rssh.myapplication;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by araumi on 2017/02/23.
 */

public class Test3dRenderer implements Renderer{
    public void onDrawFrame(GL10 gl){
    }
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 45f, (float)width / height, 1f, 50f);
    }
    public void onSurfaceCreated(GL10 gl, EGLConfig config){
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
    }
}
