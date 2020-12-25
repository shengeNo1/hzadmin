package me.shengeNo1.config;

import lombok.RequiredArgsConstructor;
import me.shengeNo1.modules.security.config.bean.SecurityProperties;
import me.shengeNo1.modules.security.security.JwtAccessDeniedHandler;
import me.shengeNo1.modules.security.security.JwtAuthenticationEntryPoint;
import me.shengeNo1.modules.security.security.TokenProvider;
import me.shengeNo1.modules.security.service.OnlineUserService;
import me.shengeNo1.modules.security.service.UserCacheClean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.filter.CorsFilter;

/**
 * @author 深哥哥的小迷妹 liuyuanshenno.1@gmail.com
 * @version 1.0.0
 * @ClassName SpringSecurityConfig.java
 * @Description TODO
 * @createTime 2020年12月25日 20:47:00
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final CorsFilter corsFilter;
    private final JwtAuthenticationEntryPoint authenticationErrorHandler;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final ApplicationContext applicationContext;
    private final SecurityProperties properties;
    private final OnlineUserService onlineUserService;
    private final UserCacheClean userCacheClean;



}
