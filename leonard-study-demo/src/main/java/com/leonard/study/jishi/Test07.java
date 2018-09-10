package com.leonard.study.jishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leonard
 * @date 2018/8/25 10:03
 */
public class Test07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //n 个约束条件
        int m = scanner.nextInt();//m 个查询
        List<String> nList = new ArrayList<String>(); //约束条件list
        List<String> mList = new ArrayList<String>(); //计算结果list
        for (int i = 0; i <= n; i++) {
            String str = scanner.nextLine();
            nList.add(str);
        }
        for (int i = 0; i < m; i++) {
            String str = scanner.nextLine();
            mList.add(str);
        }
        System.out.println("有" + n + "已知的约束条件；有" + m + "个查询。");

        //根据约束条件计算结果
        for (String str : mList) {
            String[] arr = str.split(" ");
            System.out.println(str + "=" );
        }

    }
}
