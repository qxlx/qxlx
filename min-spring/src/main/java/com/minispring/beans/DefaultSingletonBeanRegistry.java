package com.minispring.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author qxlx
 * @date 2024/4/6 21:04
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    // 用于存储所有单利bean的别名
    protected List<String> beanNames = new ArrayList<>();
    //存储Bean名称和实现类的映射关系
    protected Map<String,Object> singletons = new ConcurrentHashMap<>(256);

    @Override
    public void registerBeanDefinition(String beanName, Object singletionObject) {
        synchronized (this.singletons) {
            this.singletons.put(beanName,singletionObject);
            this.beanNames.add(beanName);
        }
    }

    @Override
    public Object getSingleton(String baenName) {
        return singletons.get(baenName);
    }

    @Override
    public boolean containsBeanSingleton(String name) {
        return singletons.containsKey(name);
    }

    @Override
    public String[] getSingletonNames() {
        return (String[]) this.beanNames.toArray();
    }

    protected void removeSingleton(String beanName) {
        synchronized (this.singletons) {
            this.beanNames.remove(beanName);
            this.singletons.remove(beanName);
        }
    }
}
