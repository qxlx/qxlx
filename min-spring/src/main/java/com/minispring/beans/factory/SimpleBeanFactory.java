package com.minispring.beans.factory;

import com.minispring.beans.BeansException;
import com.minispring.beans.DefaultSingletonBeanRegistry;
import com.minispring.beans.factory.config.BeanDefinition;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author qxlx
 * @date 2024/4/5 22:33
 */
public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory, BeanDefinitionRegistry{

    // 保留bean信息
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private List<String> beanDefinitionNames = new ArrayList<>();
    // getBean 容器的核心方法
    @Override
    public Object getBean(String beanNames) throws BeansException {
        Object singleton = this.singletons.get(beanNames);
        if (Objects.isNull(singleton)) {
            int i = beanNames.indexOf(beanNames);
            if (i == -1) {
                throw new BeansException("");
            } else {
                BeanDefinition beanDefinition = beanDefinitionMap.get(i);
                try {
                    singleton = Class.forName(beanDefinition.getClassName()).newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                singletons.put(beanDefinition.getId(),singleton);
            }
        }
        return singleton;
    }

    @Override
    public void registerBeanDefinition(String beanName, Object obj) {
        this.registerBeanDefinition(beanName,obj);
    }

    @Override
    public boolean containsBean(String name) {
        return containsBean(name);
    }

    @Override
    public boolean isSingleton(String name) {
        return BeanDefinition.SCOPE_SINGLETON.equals(this.beanDefinitionMap.get(name).getScope());
    }

    @Override
    public boolean isPrototype(String name) {
        return BeanDefinition.SCOPE_PROTOTYPE.equals(this.beanDefinitionMap.get(name).getScope());
    }

    @Override
    public Class<?> getType(String name) {
        return this.beanDefinitionMap.get(name).getClass();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition bd) {
        this.beanDefinitionMap.put(name, bd);
        this.beanDefinitionNames.add(name);
        if (!bd.isLazyInit()) {
            try {
                getBean(name);
            } catch (BeansException e) {
            }
        }
    }

    @Override
    public void removeBeanDefinition(String name) {
        this.beanDefinitionMap.remove(name);
        this.beanDefinitionNames.remove(name);
        this.removeSingleton(name);
    }

    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return this.beanDefinitionMap.get(name);
    }

    @Override
    public boolean containsBeanDefinition(String name) {
        return this.beanDefinitionMap.containsKey(name);
    }
}
