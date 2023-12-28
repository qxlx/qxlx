package com.exception;

/**
 * @author jiabaobao
 * @date 2023/12/23 5:57 PM
 */
public class FinllyTest {

    public static void main(String[] args) {
        try {
            System.out.println("try{}");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }

}
