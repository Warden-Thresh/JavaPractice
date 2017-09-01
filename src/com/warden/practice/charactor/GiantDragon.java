package com.warden.practice.charactor;

/**
 * Created by Warden on 2017/9/1.
 */
public class GiantDragon {
    private GiantDragon(){

    }
    private static GiantDragon instance = new GiantDragon();
    public static GiantDragon getInstance(){
        return instance;
    }
}
