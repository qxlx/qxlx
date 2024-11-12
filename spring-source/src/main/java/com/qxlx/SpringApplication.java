package com.qxlx;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qxlx
 * @date 2024/11/12 22:20
 */
public class SpringApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object user = ioc.getBean("user");
        System.out.println(user);
    }

}
