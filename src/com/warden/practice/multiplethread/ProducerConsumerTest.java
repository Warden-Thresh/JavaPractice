package com.warden.practice.multiplethread;

/**
 * Created by Warden on 2017/8/31.
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        new ProducerThread(stack, "Producer1").start();
        new ProducerThread(stack, "Producer2").start();
        new ConsumerThread(stack, "Consumer1").start();
        new ConsumerThread(stack, "Consumer2").start();
        new ConsumerThread(stack, "Consumer3").start();
    }
}
