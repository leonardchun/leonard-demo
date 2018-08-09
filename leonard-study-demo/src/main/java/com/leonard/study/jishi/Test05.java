package com.leonard.study.jishi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leonard
 * @date 2018/8/9 13:11
 */
public class Test05 {
    public static void main(String[] args) {
        //存数据
        List<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(343);
        list.add(5454);
        list.add(888);
        //给定数
        int num = 888;
        //判断给定数是否和最后一个相等
       if (list.get(list.size()-1) == num){
           System.out.println("arraylist的最后一个数字等于给定数，其数字为：" + list.get(list.size()-1));
       }else {
           System.out.println("arraylist的最后一个数字不等于给定数" + num);
       }
    }
}
