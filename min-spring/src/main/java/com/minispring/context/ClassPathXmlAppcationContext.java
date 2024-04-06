package com.minispring.context;

import com.minispring.beans.BeansException;
import com.minispring.beans.factory.BeanFactory;
import com.minispring.beans.factory.SimpleBeanFactory;
import com.minispring.beans.xml.XmlBeanDefinitionReader;
import com.minispring.core.ClassPathXmlResource;
import com.minispring.core.Resource;
import com.minispring.event.ApplicationEvent;
import com.minispring.event.ApplicationEventPublisher;

/**
 *
 * 1.解析XML文件中内容
 * 2.加载解析的内容 构建BeanDefinition
 * 3.读取BeanDeftnition的配置信息，实例话bean 然后注入到BeanFactoty容器中
 * @author qxlx
 * @date 2024/4/5 21:59
 */
public class ClassPathXmlAppcationContext implements BeanFactory, ApplicationEventPublisher {

    BeanFactory beanFactory;

    public ClassPathXmlAppcationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory beanFactory = new SimpleBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(String beanName, Object obj) {
        this.beanFactory.registerBeanDefinition(beanName,obj);
    }

    @Override
    public boolean containsBean(String name) {
        return this.beanFactory.containsBean(name);
    }

    @Override
    public boolean isSingleton(String name) {
        return this.beanFactory.isSingleton(name);
    }

    @Override
    public boolean isPrototype(String name) {
        return this.beanFactory.isPrototype(name);
    }

    @Override
    public Class<?> getType(String name) {
        return this.getType(name);
    }

    @Override
    public void publishEvent(ApplicationEvent event) {

    }
}
