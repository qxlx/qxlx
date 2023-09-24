package com.jia.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jiabaobao
 * @date 2023/9/10 10:27 AM
 */
public class LockDemo {

    private static Map<Integer,Integer> cacheMap = new HashMap<>();
    private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public void write(Integer key, Integer value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println("当前"+key+"正在写入");
            Thread.sleep(500);
            cacheMap.put(key,value);
            System.out.println("当前"+key+"写入完毕");
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void read(Integer key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println("当前"+key+"正在读取");
            cacheMap.get(key);
            System.out.println("当前"+key+"读取完毕");
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }


    public static void main(String[] args) {
        LockDemo lockDemo  = new LockDemo();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                lockDemo.write(finalI, finalI);
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                lockDemo.read(finalI);
            }).start();
        }
    }

}
