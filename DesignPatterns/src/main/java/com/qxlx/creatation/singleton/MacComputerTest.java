package com.qxlx.creatation.singleton;

/**
 * @author jiabaobao
 * @date 2022/2/20 11:32 PM
 */
public class MacComputerTest {

    public static void main(String[] args) {
        MacComputer mac = MacComputer.getMac();
        MacComputer macB = MacComputer.getMac();
        System.out.println(mac == macB);
    }
}
