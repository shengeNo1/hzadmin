package me.shengeNo1.modules.security.config;

import me.shengeNo1.modules.security.config.bean.LoginProperties;
import me.shengeNo1.modules.security.config.bean.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LYS liuyua776@gmail.com
 * @version 1.0.0
 * @ClassName ConfigBeanConfiguration.java
 * @Description TODO
 * @createTime 2020年12月25日 13:39:00
 */
@Configuration
public class ConfigBeanConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "login", ignoreUnknownFields = true)
    public LoginProperties loginProperties(){
        return new LoginProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "jwt", ignoreUnknownFields = true)
    public SecurityProperties securityProperties() {
        return new SecurityProperties();
    }
}
