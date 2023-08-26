package com.qxlx.behavioral.chain.ext;

/**
 * @author jiabaobao
 * @date 2022/4/10 10:31 PM
 */
public class EncodingFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("EncodingFilter before...");
        filterChain.doFilter(request,response,filterChain);
        System.out.println("EncodingFilter after...");
    }
}
