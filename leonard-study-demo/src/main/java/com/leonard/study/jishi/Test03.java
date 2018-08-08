package com.leonard.study.jishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 选一个四位数,将各位数上的数字按从大到小排列.如9731.然后再从小到大排列,如1379
 * 把两数相减.如：9731-1379=8352.然后将相减后的数字继续按上述方法，得到相减的值，
 * 依次输出每次的 9731-1379=8352
 *
 * @author leonard
 * @date 2018/8/7 20:39
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个四位数：");
        int num = scanner.nextInt();
        getResult(num);

    }

    private static void getResult(int num) {
        int a = num / 1000;           //千位
        int b = (num % 1000) / 100;     //百位
        int c = num % 1000 % 100 / 10;    //十位
        int d = num % 1000 % 100 % 10;    //个位

        int[] arr = new int[4];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;
        //从小到大排序
        //bubbleSort(arr);
        quickSort(arr);
        int numSort = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
        System.out.println("输出：" + num + "-" + numSort + "=" + (num - numSort));
        if (num > numSort) {
            getResult((num - numSort));
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    private static void selectionSort(int[] arr) {
    }

    /**
     * 快速排序
     *
     * @param arr
     */
    private static void quickSort(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {

    }
}
