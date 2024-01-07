package com.qxlx.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qxlx
 * @date 2023/12/30 8:08 PM
 */
@Configuration
public class ApolloConfig {

    @Bean
    public void config() {
        Config appConfig = ConfigService.getAppConfig();
        appConfig.addChangeListener(configChangeEvent -> {
            System.out.println("change for nameSpace" + configChangeEvent.getNamespace());
            for (String changeKey :  configChangeEvent.changedKeys()) {
                ConfigChange change = configChangeEvent.getChange(changeKey);
                System.out.println(change.getPropertyName() + ",oldValue:" +change.getOldValue() +",newValue:"+change.getNewValue());
            }
        });
    }

}
