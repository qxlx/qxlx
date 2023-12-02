package com.qxlx.behavioral.strategy;

/**
 * @author jiabaobao
 * @date 2023/11/20 10:27 PM
 */
public class CacheContext {

    private UserCache userCache;

    public CacheContext(UserCache userCache) {
        this.userCache = userCache;
    }


    public void run() {
        userCache.cache();
    }

}
