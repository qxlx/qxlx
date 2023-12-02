package com.qxlx.behavioral.strategy;

/**
 * @author jiabaobao
 * @date 2023/11/20 10:26 PM
 */
public class LRUCache implements UserCache{

    @Override
    public void cache() {
        System.out.println("LRU算法");
    }

}
