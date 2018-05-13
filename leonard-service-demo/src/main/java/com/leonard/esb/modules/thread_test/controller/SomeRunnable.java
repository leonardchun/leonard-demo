package com.leonard.esb.modules.thread_test.controller;

/*
 * 文件名：SomeRunnable
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017-12-12 02:19 PM
 */
public class SomeRunnable  implements Runnable{
    @Override
    public void run() {
        System.out.println("我是Runnable线程" + Math.random());

    }
}
