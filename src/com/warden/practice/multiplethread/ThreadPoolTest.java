package com.warden.practice.multiplethread;

import java.util.Scanner;

/**
 * Created by Warden on 2017/9/1.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        int sleep = 1000;
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("第一个整数：" + a);
        int b = scanner.nextInt();
        System.out.println("第二个整数" + b);
        while (true){
            pool.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(sleep );
                sleep = sleep>100?sleep-100:sleep;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
