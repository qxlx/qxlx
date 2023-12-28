package com.jia.dp;

import java.util.concurrent.TimeUnit;

/**
 * @author jiabaobao
 * @date 2023/12/23 11:13 PM
 */
public class Proxy {

    private boolean isStart = false;
    private boolean termial = false;
    private Thread runTask;

    synchronized void start () {

        runTask = new Thread(() -> {
            if (isStart) {
                return;
            }

            isStart = true;

            while (!Thread.currentThread().isInterrupted() || !termial) {
                try {
                    System.out.println("send->监控数据>监控平台");
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }

            isStart = false;
            System.out.println(Thread.currentThread().getName() + " stop");
        });

        runTask.start();
    }

    synchronized void stop () {
        runTask.interrupt();
        termial = true;
    }

}
