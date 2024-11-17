package com.qxlx.proxy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author qxlx
 * @date 2024/11/16 15:04
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = "com.qxlx.proxy")
public class AppConfig {
}
