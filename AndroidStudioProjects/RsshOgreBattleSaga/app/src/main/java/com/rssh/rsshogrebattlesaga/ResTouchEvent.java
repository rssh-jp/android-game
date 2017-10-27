package com.rssh.rsshogrebattlesaga;

/**
 * Created by araumi on 2017/10/26.
 */

public class ResTouchEvent {
    public String aId;
    public boolean aResult;
    public ResTouchEvent(){
        this.aId = "";
        this.aResult = false;
    }
    public ResTouchEvent(String id){
        this.aId = id;
        this.aResult = false;
    }
    public ResTouchEvent(String id, boolean result){
        this.aId = id;
        this.aResult = result;
    }
    public boolean checkId(String id){return aId == id;}
}
