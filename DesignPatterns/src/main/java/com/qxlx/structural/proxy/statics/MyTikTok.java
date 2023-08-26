package com.qxlx.structural.proxy.statics;

/**
 * @author jiabaobao
 * @date 2022/4/11 10:48 PM
 */
public class MyTikTok implements TikTok{

    private TikTok proxyTikTok;

    public void setProxyTikTok(TikTok proxyTikTok) {
        this.proxyTikTok = proxyTikTok;
    }

    @Override
    public void play() {
        proxyTikTok.play();
        System.out.println("qxlx" );
    }
}
