package com.leonard.cache.modules.thread_test.controller;

import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java实现高并发
 * <p>
 * 线程执行要完成的任务
 * 创建并发线程放入线程池 然后弄一个计数器，等待所有线程都等待就绪 再触发并发访问
 */
public class HighConcurrencyServer {

    public static void main(String[] args) {

        int count = 1000;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        ExecutorService executorService = Executors.newFixedThreadPool(count);

        for (int i = 0; i < count; i++)
            executorService.execute(new HighConcurrencyServer().new Task(cyclicBarrier));

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public class Task implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                // 等待所有任务准备就绪
                cyclicBarrier.await();
                // 测试内容
                System.out.println("时间：" + new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
