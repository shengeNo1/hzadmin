package me.shengeNo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LYS liuyua776@gmail.com
 * @version 1.0.0
 * @ClassName ConfigurerAdapter.java
 * @Description TODO
 * @createTime 2020年12月24日 20:57:00
 */
@Configuration
public class ConfigurerAdapter implements WebMvcConfigurer {

    @Bean
    public CorsFilter corsFilter(){
        System.out.println("d");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


}
