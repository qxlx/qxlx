package com.qxlx.spingboot.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author qxlx
 * @date 2024/11/16 18:15
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        event.getShow();
    }

}
