package com.rssh.rsshogrebattlesaga;

/**
 * Created by t-araumi on 2017/09/10.
 */

public class Global {
    private static Global instance = new Global();
    private Global(){
        aGameWidth = 1000;
        aGameHeight = 2000;
        aRateW = 1;
        aRateH = 1;
    }

    public static Global getInstance(){
        return instance;
    }

    public int aGameWidth;
    public int aGameHeight;
    public int aDisplayWidth;
    public int aDisplayHeight;
    public double aRateW, aRateH;

    public void setDisplaySize(int w, int h){
        this.aDisplayWidth = w;
        this.aDisplayHeight = h;
        aRateW = (double)(this.aDisplayWidth) / (double)(this.aGameWidth);
        aRateH = (double)(this.aDisplayHeight) / (double)(this.aGameHeight);
    }
    public int getDisplayWidth(){
        return this.aDisplayWidth;
    }
    public int getDisplayHeight(){
        return this.aDisplayHeight;
    }
    public int getGameWidth(){return this.aGameWidth;}
    public int getGameHeight(){return this.aGameHeight;}
    public double getWidthRate(){return aRateW;}
    public double getHeightRate(){return aRateH;}
}
