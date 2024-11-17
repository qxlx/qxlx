package com.qxlx.spingboot.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author qxlx
 * @date 2024/11/16 18:16
 */
@Component
public class DemoPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publishEvent(DemoEvent demoEvent) {
        this.applicationContext.publishEvent(demoEvent);
    }

}
