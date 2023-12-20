package com.jia.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jiabaobao
 * @date 2023/12/17 4:22 PM
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " before");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " before");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "t2");

        t1.start();
        t2.start();
        System.out.println("执行完毕");

    }

}
