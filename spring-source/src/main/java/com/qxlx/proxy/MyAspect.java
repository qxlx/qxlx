package com.qxlx.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author qxlx
 * @date 2024/11/16 15:06
 */
@Aspect
public class MyAspect {

    @Before("execution(* com.qxlx.proxy.*.*(..))")
    public void before() {
        System.out.println("my before");
    }

}
