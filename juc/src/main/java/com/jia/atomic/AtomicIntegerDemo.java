package com.jia.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiabaobao
 * @date 2023/9/24 8:33 AM
 */
public class AtomicIntegerDemo {

    private AtomicInteger atomicInteger = new AtomicInteger();
    private static final Integer NUM = 30;

    public static void main(String[] args) {
        AtomicIntegerDemo atomicIntegerDemo = new AtomicIntegerDemo();
        for (int i = 0; i < NUM; i++) {
            new Thread(()-> {
                int i1 = atomicIntegerDemo.atomicInteger.addAndGet( 1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println(atomicIntegerDemo.atomicInteger.get());
    }

}
