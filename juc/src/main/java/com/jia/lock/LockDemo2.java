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
public class LockDemo2 {

    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        readLock.lock();
        System.out.println("读取数据");
        writeLock.lock();
        readLock.unlock();
        writeLock.lock();
        System.out.println("写入数据");
        readLock.lock();
        System.out.println("读取数据");
        writeLock.unlock();
        readLock.unlock();
    }

}
