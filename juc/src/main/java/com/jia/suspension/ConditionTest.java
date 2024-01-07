package com.jia.suspension;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qxlx
 * @date 2023/12/30 3:31 PM
 */
public class ConditionTest {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Object obj;

    public Object read () {
        try {
            lock.lock();
            while (obj == null) {
                System.out.println("getLock");
                condition.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return obj;
    }

    public void write() {
        try {
            lock.lock();
            obj = new Object();
            condition.signalAll();
            System.out.println("唤醒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest test = new ConditionTest();

        new Thread(()-> {
            test.read();
        }).start();

        new Thread(()-> {
            test.write();
        }).start();

        TimeUnit.SECONDS.sleep(1);
    }


}
