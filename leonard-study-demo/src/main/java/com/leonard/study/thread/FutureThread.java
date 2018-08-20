package com.leonard.study.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Future 实现线程
 *
 * @author leonard
 * @date 2018/8/20 17:52
 */
public class FutureThread implements Callable<Integer> {

    private String name;

    public FutureThread(String name) {
        this.name = name;
    }

    public Integer call() throws Exception {
        System.out.println(System.currentTimeMillis() + "线程：" + name + "运行中!");
        Random random = new Random();
        int num = random.nextInt(100);
        Thread.sleep(num);
        System.out.println(System.currentTimeMillis() + " " + name + "runover,res=" + num);
        return num;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        future1();
    }

    private static void future1() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        Future<Integer> futureA = executorService.submit(new FutureThread("A"));
        Future<Integer> futureB = executorService.submit(new FutureThread("B"));
        System.out.println("A,B线程请求完成！");
        int a = futureA.get(1, TimeUnit.SECONDS);
        int b = futureB.get(1, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println("所有任务执行完毕,res=" + (a + b));
    }

}
