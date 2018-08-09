package com.leonard.study.jishi;

import java.util.Scanner;

/**
 * @author leonard
 * @date 2018/8/9 13:03
 */
public class Test04 {

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = x.nextInt();
        System.out.println(method(num));
    }

    public static boolean method(int a) {
        String aStr = String.valueOf(a);
        //数字的位数
        int num = aStr.length();
        boolean flag = false;
        int lifang = 0;
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.valueOf(aStr.substring(i, i + 1));
        }
        for (int a1 : arr) {
            lifang  +=  a1 * a1 * a1;
        }
        System.out.println("各位的立方值为”" + lifang);
        if (a == lifang) {
            flag = true;
        }
        return flag;
    }
}
