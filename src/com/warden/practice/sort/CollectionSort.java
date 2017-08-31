package com.warden.practice.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Warden on 2017/8/30.
 */
public class CollectionSort extends Sort implements InterfaceSort {
    @Override
    public void sort() {
        List list = new ArrayList();
        for (int number:numbers){
            list.add(number);
        }
        Collections.sort(list);
        for (int i=0;i<list.size();i++){
            numbers[i] = (int)list.get(i);
        }
    }
}
