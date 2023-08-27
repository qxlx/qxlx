package com.jia.threadlocal;

import java.lang.ref.SoftReference;

/**
 * @author jiabaobao
 * @date 2023/8/27 2:54 PM
 */

class MyObject {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("gc 销毁了");
    }
}

public class ReferenceDemo {

    public static void main(String[] args) throws InterruptedException {

    }

    private static void softReference() throws InterruptedException {
        SoftReference<MyObject> myObjectSoftReference = new SoftReference<>(new MyObject());
        System.out.println("内存够用"+myObjectSoftReference);

        System.gc();
        Thread.sleep(1000);

        System.out.println("内存够用"+myObjectSoftReference);
    }

    private static void strongReference() throws InterruptedException {
        MyObject object = new MyObject();
        System.out.println(object);
        System.gc();
        Thread.sleep(1000);
        System.out.println(object);
    }

}
