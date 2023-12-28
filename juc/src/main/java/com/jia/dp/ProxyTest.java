package com.jia.dp;

import java.util.concurrent.TimeUnit;

/**
 * @author jiabaobao
 * @date 2023/12/23 11:13 PM
 */
public class ProxyTest {

    public static void main(String[] args) throws InterruptedException {
        Proxy proxy = new Proxy();
        proxy.start();

        TimeUnit.SECONDS.sleep(5);

        proxy.stop();

        System.out.println("man stop");
    }

}
