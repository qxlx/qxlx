package com.qxlx.behavioral.chain.ext;

/**
 * @author jiabaobao
 * @date 2022/4/10 10:27 PM
 */
public interface Filter {

    /**
     *  执行过滤方法
     * @param request
     * @param response
     * @param filterChain
     */
    void doFilter (Request request, Response response,FilterChain filterChain);
}
