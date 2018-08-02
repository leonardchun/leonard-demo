package com.leonard.study.thread;

/**
 * @author leonard
 * @date 2018/7/17 13:49
 */
public class TestMain {

    public static void main(String[] args) {
        MyThread myThread =  new MyThread("A");
        myThread.start();
    }
}
