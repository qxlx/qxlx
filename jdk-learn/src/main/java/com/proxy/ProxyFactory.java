package com.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author qxlx
 * @date 2024/7/21 11:26
 */
public class ProxyFactory implements MethodInterceptor {

    private Object orinBean;

    public ProxyFactory(Object orinBean) {
        this.orinBean = orinBean;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object res = method.invoke(orinBean, args);
        Long costTime = System.currentTimeMillis() - startTime;
        System.out.println(orinBean.getClass().getSimpleName() +"#" + method.getName() + "cost time:"+costTime);
        return res;
    }
}
