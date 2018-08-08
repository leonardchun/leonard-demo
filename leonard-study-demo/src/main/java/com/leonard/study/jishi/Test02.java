package com.leonard.study.jishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入n和b,找出1到n被b整除的个数
 *
 * @author leonard
 * @date 2018/8/7 20:38
 */
public class Test02 {

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("请输入一个整数n：");
        int n = x.nextInt();
        System.out.print("请输入一个整数b：");
        int b = x.nextInt();

        int value = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (i % b == 0) {
                list.add(i);
                value++;
            }
        }
        System.out.println("在1到" + n + "之间可以被" + b + "整除的数字个数为：" + value);

        //以下是打印上面整除的数字
        System.out.print("整除" + b + "的数字为：");
        for (int num:list){
            System.out.println(num + ",");
        }
    }
}
