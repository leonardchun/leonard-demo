package com.leonard.study.jishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leonard
 * @date 2018/8/25 11:13
 */
public class Test09 {

    //双生词
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); //数组个数t
        int n = scanner.nextInt();//n 个字符串
        List<List<String>> lists = new ArrayList<List<String>>();
        for (int i = 0; i < t; i++) {
            List<String> stringList = new ArrayList<String>();
            for (int j = 0; j <= n; j++) {
                String str = scanner.nextLine();
                stringList.add(str);
            }
            lists.add(stringList);
        }

        //判断双生词
        for (List<String> list : lists) {
            for (int i = 1; i < list.size(); i++) {
                for (int j = 0; j < list.size() - i; j++) {
                    if (list.get(j).length() == list.get(j + 1).length()) { //长度相等
                       if (true){ //绕成环切开
                           System.out.println("Yeah");
                       }else {
                           System.out.println("Sad");
                       }
                    }else {
                        System.out.println("Sad");
                    }
                }
            }
        }

    }
}
