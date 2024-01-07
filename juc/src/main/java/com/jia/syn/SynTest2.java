package com.jia.syn;

/**
 * @author qxlx
 * @date 2024/1/2 10:30 PM
 */
public class SynTest2 {

    private Object obj = new Object();

    // 方法
    //静态方法-锁住的类对象
    public static synchronized void test1() {
    }

    //普通方法-锁住的对象实例
    public synchronized void test2(){
    }


    //代码块
    public void test3 (){
        //代码块-锁住的是该类对象
        synchronized (SynTest2.class) {

        }
    }

    //代码块
    public void test4 (){
        //代码块-锁住的是该对象实例
        synchronized (this) {

        }
    }

    //代码块
    public void test5 (){
        //代码块-锁住的是该obj对象实例
        synchronized (obj) {

        }
    }

    public static void main(String[] args) {

    }
}
