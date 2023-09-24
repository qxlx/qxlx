package com.jia.interrupt;

/**
 * @author jiabaobao
 * @date 2023/9/23 2:57 PM
 */
public class DemoInterrupt implements Runnable {

    @Override
    public void run() {
        System.out.println("线程开始执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.println("程序退出");
    }


    public static void main(String[] args) throws InterruptedException {
        DemoInterrupt demoInterrupt = new DemoInterrupt();
        Thread thread = new Thread(demoInterrupt);
        thread.start();

        Thread.sleep(1000);
        System.out.println("线程中断");
        thread.interrupt();
        System.out.println("执行完毕");


        Thread.sleep(1000);
    }
}
