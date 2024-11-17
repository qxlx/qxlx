package com.qxlx.spingboot.service;

import org.springframework.stereotype.Service;

/**
 * @author qxlx
 * @date 2024/11/17 08:18
 */
@Service
public class LightService {

    public LightService() {
        System.out.println("LightService 构造方法");
    }

    public void start() {
        System.out.println("start");
    }

    public void stop() {
        System.out.println("stop");
    }

}
