package com.warden.practice.multiplethread;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Warden on 2017/8/31.
 */
public class MyStack<T> {
    LinkedList<T> values = new LinkedList<T>();
    public synchronized void push(T t){
        while (values.size()>=200){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        values.addLast(t);
    }
    public synchronized T pull(){
        while (values.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        return values.removeLast();
    }

    public T peek() {
        return values.getLast();
    }
}
