package com.qxlx.proxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qxlx
 * @date 2024/11/16 15:05
 */
public class ApplicationTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        A bean = ioc.getBean(A.class);
        B beanB = ioc.getBean(B.class);

        bean.showA();
        beanB.showB();
    }

}
