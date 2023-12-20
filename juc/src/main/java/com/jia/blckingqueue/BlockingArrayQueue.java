package com.jia.blckingqueue;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author jiabaobao
 * @date 2023/12/5 10:51 PM
 */
public class BlockingArrayQueue {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);
        new Thread(new Product(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
    }

}

class Product implements Runnable{

    private BlockingQueue<String> blockingQueue;

    public Product(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("添加元素了");
                blockingQueue.put(String.valueOf(UUID.randomUUID()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{

    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String take = blockingQueue.take();
                System.out.println("消费元素了  "+take);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
