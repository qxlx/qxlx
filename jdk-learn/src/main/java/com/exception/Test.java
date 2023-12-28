package com.exception;

/**
 * @author jiabaobao
 * @date 2023/12/23 5:39 PM
 */
public class Test {

    public static void main(String[] args) {
        try {
            Test t1 = new Test();
            t1.f2();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("get exception in exter: " + e.getMessage());
        } finally {
            System.out.println("abc");
        }
    }

    public void f2() {
        f1();
    }

    public void f1() {
        System.out.println(10 / 0);
    }

}
