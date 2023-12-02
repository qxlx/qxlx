package com.qxlx.behavioral.strategy;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiabaobao
 * @date 2023/11/20 10:33 PM
 */
public class CacheFactory {

    private static Map<String,UserCache> cache = new ConcurrentHashMap<>();

    static {
        cache.put("LRU",new LRUCache());
        cache.put("LRU",new LRUCache());
    }

    public static void run (String cacheType) {
        if (Objects.isNull(cacheType)) {
            throw new RuntimeException("");
        }
        UserCache userCache = cache.get(cacheType);
        userCache.cache();
    }

}
