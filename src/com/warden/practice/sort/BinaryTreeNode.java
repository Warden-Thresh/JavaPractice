package com.warden.practice.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Warden on 2017/8/30.
 */
public class BinaryTreeNode {
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;
    public Object value;
    public void add(Object v){
        if (null == value){
            value = v;
        }else {
            if ((Integer) v <= (Integer)value){
                if (null == leftNode){
                    leftNode = new BinaryTreeNode();
                }
                leftNode.add(v);
            }else {
                if (null == rightNode)
                    rightNode = new BinaryTreeNode();
                rightNode.add(v);
            }
        }
    }
    //中序遍历
    public List<Object> values(){
        List<Object> values = new ArrayList<>();
        if(null != leftNode)
            values.addAll(leftNode.values());
        values.add(value);
        if (null != rightNode)
            values.addAll(rightNode.values());
        return values;
    }
}
