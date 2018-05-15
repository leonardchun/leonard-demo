package com.leonard.study.thread;

public class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + "运行：" + i);
                sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("A");
        MyThread thread2 = new MyThread("B");

        thread1.start();
        thread2.start();
    }
}
