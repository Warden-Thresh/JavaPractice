package com.warden.practice.sort;

/**
 * Created by Warden on 2017/8/30.
 */
public class SelectionSort extends Sort implements InterfaceSort{
    public SelectionSort(int [] numbers){
        this.numbers = numbers;
    }
    @Override
    public void sort() {
        for (int j = 0;j <numbers.length-1;j++) {
            for (int i = j + 1; i < numbers.length; i++) {
                if (numbers[i] < numbers[j]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
    }
}
