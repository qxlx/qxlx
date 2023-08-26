package com.qxlx.structural.proxy.statics;

/**
 * @author jiabaobao
 * @date 2022/4/11 10:49 PM
 */
public class ProxyTest {

    public static void main(String[] args) {
        MyTikTok tikTok = new MyTikTok();
        tikTok.setProxyTikTok(new ProxyTikTok());

        tikTok.play();
    }

}
