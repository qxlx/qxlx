package com.minispring.beans.factory;

import com.minispring.beans.BeansException;
import com.minispring.beans.factory.config.BeanDefinition;


/**
 * bean容器定义接口，其实就是
 * @author qxlx
 * @date 2024/4/5 22:20
 */
public interface BeanFactory {

    /**
     * 根据BeanName 获取Bean
     * @param baenName
     * @return
     * @throws BeansException
     */
    Object getBean(String baenName) throws BeansException;

    /**
     * 根据BeanDefition注册bean
     */
    void registerBeanDefinition(String beanName,Object obj);

    /**
     * 查询是否包含Bean
     * @param name
     * @return
     */
    boolean containsBean(String name);

    boolean isSingleton (String name);

    boolean isPrototype (String name);

    Class<?> getType(String name);

}
