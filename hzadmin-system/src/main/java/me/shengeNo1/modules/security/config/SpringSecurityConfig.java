package me.shengeNo1.modules.security.config;

import io.swagger.models.HttpMethod;
import lombok.RequiredArgsConstructor;
import me.shengeNo1.modules.security.config.bean.SecurityProperties;
import me.shengeNo1.modules.security.security.JwtAccessDeniedHandler;
import me.shengeNo1.modules.security.security.JwtAuthenticationEntryPoint;
import me.shengeNo1.modules.security.security.TokenProvider;
import me.shengeNo1.modules.security.service.OnlineUserService;
import me.shengeNo1.modules.security.service.UserCacheClean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//    private final TokenProvider tokenProvider;
//    private final CorsFilter corsFilter;
//    private final JwtAuthenticationEntryPoint authenticationErrorHandler;
//    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
//    private final ApplicationContext applicationContext;
//    private final SecurityProperties properties;
//    private final OnlineUserService onlineUserService;
//    private final UserCacheClean userCacheClean;

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        // 去除 ROLE_ 前缀
        return new GrantedAuthorityDefaults("");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 密码加密方式
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/")
                .permitAll();
    }
}
