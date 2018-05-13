package com.leonard.esb.modules.thread_test.controller;

/*
 * 文件名：SomeThead
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017-12-12 02:18 PM
 */
public class SomeThead extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我是Thread线程:" +i);
            try {
                SomeThead.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
