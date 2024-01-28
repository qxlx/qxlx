package com.jia.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qxlx
 * @date 2024/1/21 21:07
 */
public class DemoLock {

    private Lock lockA = new ReentrantLock();
    private Lock lockB = new ReentrantLock();

    public void f() {
        Random r = new Random();
        for ( ;;) {
            try {
                lockA.lock();
                boolean tryLock = lockB.tryLock(r.nextLong() % 10, TimeUnit.MILLISECONDS);
                if (tryLock) {
                    try {
                        lockB.lock();
                        // 处理业务逻辑
                    } finally {
                        lockB.unlock();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockA.unlock();
            }
        }
    }


    public void g() {
        for ( ;;) {
            try {
                lockB.lock();
                boolean tryLock = lockA.tryLock();
                if (tryLock) {
                    try {
                        lockA.lock();
                        // 处理业务逻辑
                    } finally {
                        lockA.unlock();
                    }
                }
            } finally {
                lockB.unlock();
            }
        }
    }

}
