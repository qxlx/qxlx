package com.minispring.beans.xml;

import com.minispring.beans.factory.BeanFactory;
import com.minispring.beans.factory.SimpleBeanFactory;
import com.minispring.beans.factory.config.BeanDefinition;
import com.minispring.core.Resource;
import org.dom4j.Element;

/**
 * 将资源封装成一个BeanDefiniton
 * @author qxlx
 * @date 2024/4/5 22:30
 */
public class XmlBeanDefinitionReader {

    SimpleBeanFactory simpleBeanFactory;

    public XmlBeanDefinitionReader(SimpleBeanFactory simpleBeanFactory) {
        this.simpleBeanFactory = simpleBeanFactory;
    }

    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            this.simpleBeanFactory.registerBeanDefinition(beanDefinition.getId(),beanDefinition.getClassName());
        }
    }
}
