package com.jia.lock;

/**
 * @author jiabaobao
 * @date 2023/9/18 9:35 PM
 */
public class DealLock {

    private Object objA = new Object();
    private Object objB = new Object();

    public void runA() throws InterruptedException {
        synchronized (objA) {
            System.out.println("获取到A锁，等待获取B锁");
            Thread.sleep(1000);
            synchronized (objB) {
                System.out.println("A、B都获取到了");
            }
        }
    }

    public void runB() throws InterruptedException {
        synchronized (objB) {
            System.out.println("获取到B锁，等待获取A锁");
            Thread.sleep(1000);
            synchronized (objA) {
                System.out.println("A、B都获取到了");
            }
        }
    }

    public static void main(String[] args) {
        DealLock dealLock = new DealLock();
        new Thread(()-> {
            try {
                dealLock.runA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                dealLock.runB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
