package com.minispring.event;

/**
 * @author qxlx
 * @date 2024/4/6 21:23
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);

}
