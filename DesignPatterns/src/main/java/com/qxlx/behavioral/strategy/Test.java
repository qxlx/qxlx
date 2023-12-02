package com.qxlx.behavioral.strategy;

/**
 * @author jiabaobao
 * @date 2022/4/20 10:58 PM
 */
public class Test {

    public static void main(String[] args) {
//        FundsContext fundsContext = new FundsContext();
//
//        fundsContext.setAbstractFundsStrategy(new GansuBkFundsStrategy());
//
//        fundsContext.loan();

        LRUCache lruCache = new LRUCache();
        CacheContext cacheContext = new CacheContext(lruCache);
        cacheContext.run();
    }

}
