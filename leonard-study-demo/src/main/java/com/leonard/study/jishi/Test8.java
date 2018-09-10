package com.leonard.study.jishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leonard
 * @date 2018/8/25 10:58
 */
public class Test8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //n 个采样点个数
        int t = scanner.nextInt();// t 个小时

        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            int num = scanner.nextInt();
            numList.add(num);
        }
        //计算
        int result = 0;


        System.out.println("序列长度为：" + result);

    }

}
