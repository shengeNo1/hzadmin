package me.shengeNo1.modules.security.security;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import me.shengeNo1.modules.security.config.bean.SecurityProperties;
import me.shengeNo1.modules.security.service.OnlineUserService;
import me.shengeNo1.modules.security.service.UserCacheClean;
import me.shengeNo1.modules.security.service.dto.OnlineUserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * @author 深哥哥的小迷妹 liuyuanshenno.1@gmail.com
 * @version 1.0.0
 * @ClassName TokenFilter.java
 * @Description TODO
 * @createTime 2020年12月25日 19:13:00
 */
@Slf4j
public class TokenFilter extends GenericFilterBean {

    private final TokenProvider tokenProvider;
    private final SecurityProperties properties;
    private final OnlineUserService onlineUserService;
    private final UserCacheClean userCacheClean;

    public TokenFilter(TokenProvider tokenProvider, SecurityProperties properties, OnlineUserService onlineUserService, UserCacheClean userCacheClean) {
        this.properties = properties;
        this.tokenProvider = tokenProvider;
        this.onlineUserService = onlineUserService;
        this.userCacheClean = userCacheClean;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = resolveToken(httpServletRequest);
        if (StrUtil.isNotBlank(token)){
            OnlineUserDto onlineUserDto = null;
            boolean cleanUserCache = false;
            try{
                onlineUserDto = onlineUserService.getOne(properties.getOnlineKey() + token);
            }catch (Exception e) {
                log.error(e.getMessage());
                cleanUserCache = true;
            }finally {
                if (cleanUserCache || Objects.isNull(onlineUserDto)) {
                    userCacheClean.cleanUserCache(String.valueOf(tokenProvider.getClaims(token).get(TokenProvider.AUTHORITIES_KEY)));
                }
            }
            if (onlineUserDto != null && StringUtils.hasText(token)) {
                Authentication authentication = tokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                // Token 续期
                tokenProvider.checkRenewal(token);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 初步检测Token
     *
     * @param request /
     * @return /
     */
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(properties.getHeader());
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(properties.getTokenStartWith())) {
            // 去掉令牌前缀
            return bearerToken.replace(properties.getTokenStartWith(), "");
        } else {
            log.debug("非法Token：{}", bearerToken);
        }
        return null;
    }
}
