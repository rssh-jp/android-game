package jp.rssh.orgabattlesaga;

/**
 * Created by araumi on 2017/10/05.
 */

public class ResTouchEvent {
    public int aId;
    public boolean aResult;
    public ResTouchEvent(){
        this.aId = 0;
        this.aResult = false;
    }
    public ResTouchEvent(int id){
        this.aId = id;
        this.aResult = false;
    }
    public ResTouchEvent(int id, boolean result){
        this.aId = id;
        this.aResult = result;
    }
}
