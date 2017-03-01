package com.example.rssh.myapplication;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by araumi on 2017/02/23.
 */

public class Test3dRenderer implements Renderer{
    Test3dMeshCube cube = new Test3dMeshCube();
    public void onDrawFrame(GL10 gl){
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -3f);

        cube.draw(gl);
    }
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

//        gl.glTranslatef(0, 0, -3f);
//        gl.glRotatef(30f, 0, 1, 0);

        GLU.gluPerspective(gl, 45f, (float)width / height, 1f, 50f);
    }
    public void onSurfaceCreated(GL10 gl, EGLConfig config){
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
    }
}
