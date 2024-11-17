package com.qxlx.spingboot.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author qxlx
 * @date 2024/11/15 21:06
 */
@Configuration
public class ValueConfig {

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
