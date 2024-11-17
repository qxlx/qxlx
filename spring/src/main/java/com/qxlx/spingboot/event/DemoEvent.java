package com.qxlx.spingboot.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author qxlx
 * @date 2024/11/16 18:13
 */
public class DemoEvent extends ApplicationEvent {

    private String name;

    public DemoEvent(String name) {
        super(name);
        this.name = name;
    }

    public void getShow() {
        System.out.println(Thread.currentThread().getName()+"\t"+name);
    }
}
