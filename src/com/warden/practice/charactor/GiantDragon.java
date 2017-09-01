package com.warden.practice.charactor;

/**
 * Created by Warden on 2017/9/1.
 */
public class GiantDragon {
    private GiantDragon(){

    }
    private static GiantDragon instance;
    public static GiantDragon getInstance(){
        if (null==instance)
            instance=new GiantDragon();
        return instance;
    }
}
