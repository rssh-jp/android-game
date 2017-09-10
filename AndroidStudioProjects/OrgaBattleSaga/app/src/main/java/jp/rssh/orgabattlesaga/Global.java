package jp.rssh.orgabattlesaga;

/**
 * Created by t-araumi on 2017/09/10.
 */

public class Global {
    private static Global instance = new Global();
    private Global(){
    }
    public static Global getInstance(){
        return instance;
    }

    public int aDisplayWidth;
    public int aDisplayHeight;
    public void setDisplaySize(int w, int h){
        this.aDisplayWidth = w;
        this.aDisplayHeight = h;
    }
    public int getDisplayWidth(){
        return this.aDisplayWidth;
    }
    public int getDisplayHeight(){
        return this.aDisplayHeight;
    }
}
