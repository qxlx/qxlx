package com.minispring.event;

import java.util.EventObject;

/**
 * @author qxlx
 * @date 2024/4/6 21:23
 */
public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }

}
