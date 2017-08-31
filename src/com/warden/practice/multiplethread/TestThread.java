package com.warden.practice.multiplethread;

import com.warden.practice.charactor.Hero;

/**
 * Created by Warden on 2017/8/31.
 */
public class TestThread {
    public static void main(String[] args) {
        final Hero garren = new Hero();
        garren.name = "盖伦";
        garren.hp = 616;

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true){
                    garren.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    garren.recover();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }
}
