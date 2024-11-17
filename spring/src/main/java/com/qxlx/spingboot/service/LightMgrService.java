package com.qxlx.spingboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qxlx
 * @date 2024/11/17 08:18
 */
@Component
public class LightMgrService {

//    @Autowired
//    private LightService lightService;

//    public LightMgrService () {
//        lightService.start();
//    }

    private LightService lightService;

    public LightMgrService(LightService lightService) {
        this.lightService = lightService;
        System.out.println("lightService 属性被注入");
    }
}
