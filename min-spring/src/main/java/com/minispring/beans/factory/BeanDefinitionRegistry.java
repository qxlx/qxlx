package com.minispring.beans.factory;

import com.minispring.beans.factory.config.BeanDefinition;

/**
 * @author qxlx
 * @date 2024/4/6 21:39
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition bd);

    void removeBeanDefinition(String name);

    BeanDefinition getBeanDefinition(String name);

    boolean containsBeanDefinition(String name);
}
