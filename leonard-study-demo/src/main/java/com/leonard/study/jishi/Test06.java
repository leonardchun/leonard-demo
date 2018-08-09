package com.leonard.study.jishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leonard
 * @date 2018/8/9 13:20
 */
public class Test06 {

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int num = x.nextInt();
        int[] arr = new int[num];

        for (int i=0; i< num;i++){
            System.out.print("请输入数组的第"+ (i+1) +"值：");
            int value = x.nextInt();
            arr[i] = value;
        }
        //快速排序或者可以冒泡排序
        Arrays.sort(arr);
        System.out.println("数组最大值：" + arr[arr.length-1] + ";最小值：" + arr[0]);

    }
}
