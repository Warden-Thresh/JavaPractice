package com.warden.practice.sort;

/**
 * Created by Warden on 2017/8/30.
 */
public class BubblingSort extends Sort implements InterfaceSort {
    public BubblingSort(int [] numbers){
        this.numbers = numbers;
    }
    @Override
    public void sort() {
        for (int j = 0;j < numbers.length;j++){
            for (int i =0;i< numbers.length-j-1;i++){
                if (numbers[i]>numbers[i+1]){
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                }
            }
        }
    }
}
