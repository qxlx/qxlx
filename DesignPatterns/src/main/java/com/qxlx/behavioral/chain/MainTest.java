package com.qxlx.behavioral.chain;

/**
 * @author jiabaobao
 * @date 2022/4/5 8:14 PM
 */
public class MainTest {

    public static void main(String[] args) {
        final Leader leader1 = new Leader();
        leader1.setName("aa");
        final Leader leader2 = new Leader();
        leader2.setName("bb");

        leader1.setNext(leader2);

        leader1.handle();
    }

}
