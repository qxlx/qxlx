package com.minispring.beans;

/**
 * @author qxlx
 * @date 2024/4/6 21:01
 */
public interface SingletonBeanRegistry {

    void registerBeanDefinition(String beanName,Object singletionObject);


    Object getSingleton(String baenName);

    boolean containsBeanSingleton(String name);

    String [] getSingletonNames();
}
