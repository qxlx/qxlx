package com.qxlx.spingboot;

import com.qxlx.spingboot.config.ValueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiabaobao
 * @date 2023/10/22 6:23 PM
 */
@SpringBootApplication
@RestController
//@ConditionalOnNacosDiscoveryEnabled
public class ApplicationContext {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationContext.class,args);
    }

//    @RequestMapping(path = "/hi",method = RequestMethod.GET)
//    public String hi() {
//        return "hi springboot";
//    }
}
