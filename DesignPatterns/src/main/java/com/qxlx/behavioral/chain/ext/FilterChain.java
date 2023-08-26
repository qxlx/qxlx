package com.qxlx.behavioral.chain.ext;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jiabaobao
 * @date 2022/4/10 10:28 PM
 */
public class FilterChain implements Filter{

    private static List<Filter> filterList = new LinkedList<>();

    private Filter myFilter;

    private static int filterIndex = 0;

    /**
     * 添加一个职责工作链
     * @param filter
     */
    public void addFilter (Filter filter) {
        filterList.add(filter);
    }

    public void addMyFilter (Filter filter) {
        myFilter = filter;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        if (filterIndex < filterList.size()) {
            Filter filter = filterList.get(filterIndex);
            filterIndex++;
            filter.doFilter(request,response,filterChain);
        } else {
            myFilter.doFilter(request,response,filterChain);
        }
    }
}
