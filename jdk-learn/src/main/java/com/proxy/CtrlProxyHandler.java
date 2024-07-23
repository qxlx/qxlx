package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.stream.StreamSupport;

/**
 * @author qxlx
 * @date 2024/7/20 22:20
 */
public class CtrlProxyHandler implements InvocationHandler {

    private Object origBean;

    public CtrlProxyHandler(Object origBean) {
        this.origBean = origBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object res = method.invoke(origBean, args);
        long costTime = System.currentTimeMillis() - startTime;

        System.out.println(origBean.getClass().getSimpleName()+"#"+method.getName() + "cost time:"+ costTime);
        return res;
    }
}
