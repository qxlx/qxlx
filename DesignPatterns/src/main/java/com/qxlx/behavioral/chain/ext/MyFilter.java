package com.qxlx.behavioral.chain.ext;

/**
 * @author jiabaobao
 * @date 2022/4/10 10:32 PM
 */
public class MyFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("MyFilter before...");
        System.out.println("hahaha 我是中间执行人");
        System.out.println("MyFilter after...");
    }
}
