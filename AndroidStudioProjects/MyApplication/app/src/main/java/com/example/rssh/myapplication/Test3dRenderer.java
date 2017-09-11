package com.example.rssh.myapplication;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by araumi on 2017/02/23.
 */

public class Test3dRenderer implements Renderer{
    float aAngle = 0;
    Test3dMeshCube cube = new Test3dMeshCube();
    public void onSurfaceCreated(GL10 gl, EGLConfig config){
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glEnable(GL10.GL_LIGHTING);
        gl.glEnable(GL10.GL_LIGHT0);
    }
    public void onDrawFrame(GL10 gl){
        aAngle += 1;
        if(aAngle >= 360){
            aAngle -= 360;
        }
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glFrontFace(GL10.GL_CCW);
        gl.glCullFace(GL10.GL_BACK);

        gl.glTranslatef(0, 0, -5f);
        gl.glRotatef(aAngle, 0, 1, 0);
        gl.glRotatef(30f, 1, 0, 0);


        cube.draw(gl);
    }
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        GLU.gluPerspective(gl, 45f, (float)width / height, 1f, 50f);
    }
}
