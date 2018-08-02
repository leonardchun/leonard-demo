package com.leonard.study.thread;

/**
 * @author leonard
 * @date 2018/7/22 14:41
 */
public class MythreadA extends Thread{

    @Override
    public void run(){
        while (true){
            if (this.isInterrupted()){
                System.out.println("线程已结束！");
                return;
            }
            System.out.println(String.format("当前时间：" + System.currentTimeMillis()));
        }
    }

    public static void main(String[] args) {
        MythreadA mythreadA = new MythreadA();
        try {
            mythreadA.start();
            mythreadA.sleep(1);
            mythreadA.interrupt();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
