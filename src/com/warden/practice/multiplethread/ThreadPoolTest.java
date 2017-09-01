package com.warden.practice.multiplethread;

/**
 * Created by Warden on 2017/9/1.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        for (int i = 0; i < 50; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务");
                }
            };
            pool.add(task);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
