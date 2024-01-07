package com.jia.dp;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author qxlx
 * @date 2024/1/1 9:01 PM
 */
public class ProConTest {

    public static void main(String[] args) {

        ExecutorService threadPoolPro = Executors.newFixedThreadPool(1);
        ExecutorService threadPoolCon = Executors.newFixedThreadPool(2);
        BlockingQueue<String> q = new ArrayBlockingQueue<>(10);

        threadPoolPro.execute(()->{
            while (true) {
                try {
                    q.put(String.valueOf(UUID.randomUUID()));
                    System.out.println("生产消息----");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPoolCon.execute(()->{
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName()+"当前队列大小:"+q.size());
                    String take = q.take();
                    System.out.println(Thread.currentThread().getName()+"消费消息:"+take);
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }

}
