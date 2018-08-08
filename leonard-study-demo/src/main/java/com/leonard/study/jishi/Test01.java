package com.leonard.study.jishi;

/**
 * 找出正整数中的偶数，并输出相加后的数值，要用Long
 *
 * @author leonard
 * @date 2018/8/7 20:36
 */
public class Test01 {

    public static void main(String[] args) {

        int maxValue = Integer.MAX_VALUE;//这个值可以控制在某个数值之内的偶数 比如100以内的偶数之和
        Long sum = 0L;
        for (int i = 0; i <= maxValue; i++) {
            if (i % 2 == 0) {
                //System.out.println("我是偶数：" + i);
                sum += i;
            }
        }
        System.out.println("正整数中的偶数之和为：" + sum);
    }
}
