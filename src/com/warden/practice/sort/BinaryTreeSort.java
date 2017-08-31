package com.warden.practice.sort;

import java.util.List;

/**
 * Created by Warden on 2017/8/30.
 */
public class BinaryTreeSort extends Sort implements InterfaceSort {
    BinaryTreeNode root;
    public BinaryTreeSort(int [] numbers){
        this.numbers = numbers;
        root = new BinaryTreeNode();
    }
    @Override
    public void sort() {
        for (int number:numbers){
            root.add(number);
        }
        List<Object> list = root.values();
        for (int i =0;i<list.size();i++){
            numbers[i] = Integer.parseInt(list.get(i).toString());
        }
    }
}
