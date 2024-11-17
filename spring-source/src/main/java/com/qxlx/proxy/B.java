package com.qxlx.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qxlx
 * @date 2024/11/16 15:03
 */
@Component
public class B {

    private String name;

    @Autowired
    private A a;

    public void showB(){
        System.out.println("B");
    }

}
