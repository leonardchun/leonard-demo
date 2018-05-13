package com.leonard.cache.modules.thread_test.controller;

/*
 * 文件名：TheadTest
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017-12-12 02:26 PM
 */
public class TheadTest {

    public static void main(String[] args){
        SomeThead oneThread = new SomeThead();

        oneThread.start();

        SomeRunnable someRunnable = new SomeRunnable();
        Thread thread = new Thread(someRunnable);
        thread.start();
    }

    int count = 1;

    public synchronized void add(int value){
        this.count += value;
    }
}
