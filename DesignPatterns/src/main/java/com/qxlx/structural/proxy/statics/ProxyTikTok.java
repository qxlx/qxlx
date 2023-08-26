package com.qxlx.structural.proxy.statics;

/**
 * @author jiabaobao
 * @date 2022/4/11 10:48 PM
 */
public class ProxyTikTok implements TikTok{

    @Override
    public void play() {
        System.out.println("我是代理类,play()");
    }
}
