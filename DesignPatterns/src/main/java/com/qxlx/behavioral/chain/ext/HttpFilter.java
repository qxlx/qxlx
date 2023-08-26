package com.qxlx.behavioral.chain.ext;

/**
 * http过滤
 * @author jiabaobao
 * @date 2022/4/10 10:30 PM
 */
public class HttpFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("httpFilter before...");
        filterChain.doFilter(request,response,filterChain);
        System.out.println("httpFilter after...");
    }
}
