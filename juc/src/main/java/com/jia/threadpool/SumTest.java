package com.jia.threadpool;

import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author jiabaobao
 * @date 2023/12/22 10:57 PM
 */
public class SumTest {

    private static Long SUM = 10000000000L;

    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            new SumThread();
//        });

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Long sum = 0L;
        for (int i = 0; i < SUM; i++) {
            sum += i;
        }
        stopWatch.stop();
        System.out.println("sum:" + sum + ", time:" + stopWatch.getTotalTimeSeconds());
    }

    public static class SumThread implements Runnable {
        @Override
        public void run() {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            Long sum = 0L;
            for (int i = 0; i < SUM; i++) {
                sum += i;
            }
            stopWatch.stop();
            System.out.println("sum:" + sum + ", time:" + stopWatch.getTotalTimeSeconds());
        }
    }

}
