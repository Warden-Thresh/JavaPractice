package com.warden.practice.sort;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int length = 100000;
        System.out.println("初始化一个长度是"+length+"的随机数组");
	    int originalNumbers[] =new int[length];
	    for (int i =0;i<originalNumbers.length;i++){
	        originalNumbers[i]= (int)Math.floor(Math.random()*length);
        }
        System.out.println("初始化完成");
        System.out.println("接下来分别使用三种排序算发进行排序");
        int[] userForSort;
        userForSort = Arrays.copyOf(originalNumbers,originalNumbers.length);
        int[] sortedNumbersBySelection = performance(new SelectionSort(userForSort),"选择排序");
        userForSort = Arrays.copyOf(originalNumbers,originalNumbers.length);
        int[] sortedNumbersByBubbling = performance(new BubblingSort(userForSort),"冒泡排序");
        userForSort = Arrays.copyOf(originalNumbers,originalNumbers.length);
        int[] sortedNumbersByBinaryTreeSort = performance(new BinaryTreeSort(userForSort),"二叉树排序");
        userForSort = Arrays.copyOf(originalNumbers,originalNumbers.length);
        int[] sortedNumbersByQuickSort = performance(new BinaryTreeSort(userForSort),"快速排序排序");
        userForSort = Arrays.copyOf(originalNumbers,originalNumbers.length);
        int[] sortedNumbersByCollections = performance(new BinaryTreeSort(userForSort),"Collections");
        System.out.println("查看排序结果是否是不同的数组对象");
        System.out.println(sortedNumbersByBinaryTreeSort);
        System.out.println(sortedNumbersByBubbling);
        System.out.println(sortedNumbersBySelection);
        System.out.println(sortedNumbersByQuickSort);
        System.out.println(sortedNumbersByCollections);
        System.out.println("查看排序结果，是否内容相同");
        System.out.println("比较 选择法 和 二叉树 排序结果");
        System.out.println(Arrays.equals(sortedNumbersBySelection,sortedNumbersByBinaryTreeSort));
        System.out.println("比较 选择法 和 冒泡法 排序结果");
        System.out.println(Arrays.equals(sortedNumbersBySelection,sortedNumbersByBubbling));
        System.out.println("比较 选择法 和 快速怕排序法 排序结果");
        System.out.println(Arrays.equals(sortedNumbersBySelection,sortedNumbersByQuickSort));
        System.out.println("比较 选择法 和 Collections 排序结果");
        System.out.println(Arrays.equals(sortedNumbersBySelection,sortedNumbersByCollections));



    }
    private static int[] performance(InterfaceSort algorithm,String type){
        long startTimeMillis = System.currentTimeMillis();
        algorithm.sort();
        int sotedNumbers[]= algorithm.values();
        long endTimeMilis = System.currentTimeMillis();
        System.out.printf("%s排序，一共耗时 %d 毫秒%n",type,endTimeMilis-startTimeMillis);
        return sotedNumbers;
    }
}
