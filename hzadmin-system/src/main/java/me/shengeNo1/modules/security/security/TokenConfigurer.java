package me.shengeNo1.modules.security.security;

import lombok.RequiredArgsConstructor;
import me.shengeNo1.modules.security.config.bean.SecurityProperties;
import me.shengeNo1.modules.security.service.OnlineUserService;
import me.shengeNo1.modules.security.service.UserCacheClean;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 深哥哥的小迷妹 liuyuanshenno.1@gmail.com
 * @version 1.0.0
 * @ClassName TokenConfigurer.java
 * @Description TODO
 * @createTime 2020年12月25日 19:59:00
 */
@RequiredArgsConstructor
public class TokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final TokenProvider tokenProvider;
    private final SecurityProperties properties;
    private final OnlineUserService onlineUserService;
    private final UserCacheClean userCacheClean;

    @Override
    public void configure(HttpSecurity http) {
        TokenFilter customFilter = new TokenFilter(tokenProvider, properties, onlineUserService, userCacheClean);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
