package com.qxlx.spingboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jiabaobao
 * @date 2023/11/5 9:39 PM
 */
@Configuration
public class ConfigBean {

    @Bean
    public String serviceName() {
        return "qxlx";
    }

    /**
     * 通过{@link DynamicTp} 注解定义普通juc线程池，会享受到该框架增强能力，注解名称优先级高于方法名
     *
     * @return 线程池实例
     */
//    @DynamicTp("jucThreadPoolExecutor")
    @Bean
    public ThreadPoolExecutor jucThreadPoolExecutor() {
        return (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
    }

}
