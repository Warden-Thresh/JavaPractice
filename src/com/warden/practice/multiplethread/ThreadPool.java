package com.warden.practice.multiplethread;

import java.util.LinkedList;

/**
 * Created by Warden on 2017/9/1.
 */
public class ThreadPool {
    //线程池大小
    int threadPoolSize;
    //任务容器
    LinkedList<Runnable> tasks = new LinkedList<>();

    //试图消费任务的线程
    public ThreadPool() {
        threadPoolSize = 10;
        //启动十个任务消费者线程
        synchronized (tasks){
            for (int i=0;i<threadPoolSize;i++) {
                new TaskConsumeThread("任务消费者线程" + i).start();
            }
        }
    }
    public void add(Runnable runnable) {
        synchronized (tasks){
            tasks.add(runnable);
            //唤醒等待的线程
            tasks.notifyAll();
        }
    }
    class TaskConsumeThread extends Thread{
        public TaskConsumeThread(String name) {
            super(name);
        }
        Runnable task;
        public void run(){
            System.out.println("启动:"+this.getName());
            while (true){
                synchronized (tasks){
                    while (tasks.isEmpty()){
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName()+"获取到任务，并执行");
                task.run();
            }
        }
    }
}
