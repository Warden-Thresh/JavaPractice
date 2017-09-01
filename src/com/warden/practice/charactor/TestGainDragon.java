package com.warden.practice.charactor;

/**
 * Created by Warden on 2017/9/1.
 */
public class TestGainDragon {
    public static void main(String[] args) {
        GiantDragon giantDragon1 = GiantDragon.getInstance();
        GiantDragon giantDragon2 = GiantDragon.getInstance();
        GiantDragon giantDragon3 = GiantDragon.getInstance();
        GiantDragon giantDragon4 = GiantDragon.getInstance();
        System.out.println(giantDragon1 + "\n"+giantDragon2+"\n"+giantDragon3+"\n"+giantDragon4);
    }
}
