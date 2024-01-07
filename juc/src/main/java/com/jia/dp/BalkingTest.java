package com.jia.dp;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qxlx
 * @date 2023/12/31 5:16 PM
 */
public class BalkingTest {

    private boolean inited = false;

    //第一种方式 syn
    public synchronized void init() {
        if (!inited) {
            return;
        }

        inited = true;
        //业务逻辑
    }


    private Lock lock = new ReentrantLock();

    //第二种方式 lock
    public void init2() {
        try {
            lock.lock();
            if (!inited) {
                return;
            }

            inited = true;
            //业务逻辑
        } finally {
            lock.unlock();
        }
    }

    AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    //第二种方式 cas
    public void init3() {
        if (!atomicBoolean.get()) {
            return;
        }
        atomicBoolean.compareAndSet(Boolean.FALSE, Boolean.TRUE);
        //业务逻辑
    }

}
