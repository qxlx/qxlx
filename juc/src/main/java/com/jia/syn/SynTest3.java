package com.jia.syn;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @author qxlx
 * @date 2024/1/3 9:58 PM
 */
public class SynTest3 {

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        Object obj = new Object();

        System.out.println(Thread.currentThread().getName() + "\t" + ClassLayout.parseInstance(obj).toPrintable());

        Thread thread1 = new Thread(() -> {
            synchronized (obj) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + ClassLayout.parseInstance(obj).toPrintable());
            }
        }, "T1");

        thread1.start();


        Thread.sleep(1000);

        Thread thread = new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "\t" + ClassLayout.parseInstance(obj).toPrintable());
            }
        }, "T2");

        thread.start();


        Thread thread3 = new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "\t" + ClassLayout.parseInstance(obj).toPrintable());
            }
        }, "T3");

        thread3.start();

    }

    public static void test() {
        // System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        o.hashCode(); //偏向锁撤销
        Object o = new Object();

        new Thread(() -> {
            synchronized (o) { // 101
//            synchronized (SynTest.class) { // 000
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + ClassLayout.parseInstance(o).toPrintable());
            }
        }, "T1").start();
    }

}
