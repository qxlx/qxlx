package com.minispring.beans.factory.config;

import com.minispring.beans.ArgumentValues;
import com.minispring.beans.PropertyValues;
import lombok.Data;

/**
 * bean定义信息
 * @author qxlx
 * @date 2024/4/5 21:55
 */
@Data
public class BeanDefinition {

    public static String SCOPE_SINGLETON = "singleton";
    public static String SCOPE_PROTOTYPE = "prototype";

    // 加载的时候初始化
    private boolean lazyInit = false;
    // 记录bean之间的依赖关系
    private String [] dependsOn;
    private ArgumentValues constructorArgumentValues;
    private PropertyValues propertyValues;
    // bean实例化之后是否要框架调用初始化方法
    private String initMethodName;
    private volatile Object beanClass;
    private String id;
    private String className;
    private String scope = SCOPE_SINGLETON;

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

}
