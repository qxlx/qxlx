package com.jia.atomic;

import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author qxlx
 * @date 2023/10/15 9:52 AM
 */

class MyNumber {

    public Long num = new Long(0);

    public synchronized long synAddNumer() {
        return num++;
    }

    public AtomicInteger atomicInteger = new AtomicInteger(0);

    public int atomicIntegerAddNumer() {
        return atomicInteger.getAndIncrement();
    }

    public LongAdder longAdder = new LongAdder();
    public int longAdderAddNumber(){
        longAdder.increment();
        return longAdder.intValue();
    }

}

public class LongAddrCalcDemo {

    public static final int THREAD_NUM = 50;
    public static final int ADD_NUM = 1000000;

    public static void main(String[] args) throws InterruptedException {
        MyNumber myNumber = new MyNumber();
        StopWatch stopWatch = new StopWatch();

        CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);
        CountDownLatch countDownLatch2 = new CountDownLatch(THREAD_NUM);
        CountDownLatch countDownLatch3 = new CountDownLatch(THREAD_NUM);

        stopWatch.start("1.加锁方式耗时");
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(()-> {
                for (int j = 0; j < ADD_NUM ; j++) {
                    long numer = myNumber.synAddNumer();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("1.加锁方式,num:"+myNumber.num);
        stopWatch.stop();


        stopWatch.start("2.atomic");
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(()-> {
                for (int j = 0; j < ADD_NUM ; j++) {
                    long numer = myNumber.atomicIntegerAddNumer();
                }
                countDownLatch2.countDown();
            }).start();
        }
        countDownLatch2.await();
        System.out.println("2.atomic,num:"+myNumber.atomicInteger);
        stopWatch.stop();


        stopWatch.start("3.longadder");
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(()-> {
                for (int j = 0; j < ADD_NUM ; j++) {
                    long numer = myNumber.longAdderAddNumber();
                }
                countDownLatch3.countDown();
            }).start();
        }
        countDownLatch3.await();
        System.out.println("3.longadder,num:"+myNumber.longAdder);
        stopWatch.stop();

        System.out.println("date:"+stopWatch.prettyPrint());
    }

}
