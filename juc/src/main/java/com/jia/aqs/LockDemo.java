package com.jia.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiabaobao
 * @date 2023/9/3 3:46 PM
 */
public class LockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        lock.lock();

        lock.unlock();
    }

}
