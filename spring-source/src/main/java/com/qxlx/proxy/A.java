package com.qxlx.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qxlx
 * @date 2024/11/16 15:02
 */
@Component
public class A {

    private String name;

    @Autowired
    private B b;

    public void showA(){
        System.out.println("A");
    }
}
