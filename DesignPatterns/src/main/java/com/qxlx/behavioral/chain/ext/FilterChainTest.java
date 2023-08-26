package com.qxlx.behavioral.chain.ext;

/**
 * @author jiabaobao
 * @date 2022/4/10 10:37 PM
 */
public class FilterChainTest {

    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();

        Filter httpFilter = new HttpFilter();
        Filter encodingFilter = new EncodingFilter();
        Filter myFilter = new MyFilter();

        filterChain.addFilter(httpFilter);
        filterChain.addFilter(encodingFilter);
        filterChain.addMyFilter(myFilter);

        filterChain.doFilter(new Request(),new Response(),filterChain);

    }


}
