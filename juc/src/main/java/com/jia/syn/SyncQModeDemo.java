package com.jia.syn;

public class SyncQModeDemo {

    public static void main(String[] args) throws InterruptedException {
        SyncQModeDemo demo = new SyncQModeDemo();

        demo.startThreadA();
        //控制线程执行时间
        Thread.sleep(100);
        demo.startThreadB();
        Thread.sleep(100);
        demo.startThreadC();
    }

    final Object lock = new Object();

    public void startThreadA() {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("A get lock");
                try {
//                    Thread.sleep(300);
                    lock.wait(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A release lock");
            }
        }, "thread-A").start();
    }

    public void startThreadB() {
        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("B get lock");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B release lock");
            }
        }, "thread-B").start();
    }

    public void startThreadC() {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("C get lock");
            }
        }, "thread-C").start();
    }

}