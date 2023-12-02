package com.qxlx.spingboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
