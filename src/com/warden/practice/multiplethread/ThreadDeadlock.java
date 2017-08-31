package com.warden.practice.multiplethread;

import com.warden.practice.charactor.Hero;

/**
 * Created by Warden on 2017/8/31.
 */
public class ThreadDeadlock {
    public static void main(String[] args){
        final Hero ahri = new Hero();
        ahri.name = "九尾妖狐";
        final Hero annie = new Hero();
        annie.name = "安妮";

        Thread t1 = new Thread(){
          public void run(){
              synchronized (ahri){
                  System.out.println("t1 已占有"+ahri.getName());
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("t1 试图占有"+annie.getName());
                  System.out.println("t1等待中。。。");
                  synchronized (annie){
                      System.out.println("do something");
                  }
              }
          }
        };
        t1.start();
        Thread t2 = new Thread() {

            @Override
            public void run() {
                synchronized (annie) {
                    System.out.println("t2已占有安妮");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2试图占有九尾妖狐");
                    System.out.println("t2等待中。。。。");
                    synchronized (ahri){
                        System.out.println("do something");
                    }
                }
            }
        };
        t2.start();
    }
}
