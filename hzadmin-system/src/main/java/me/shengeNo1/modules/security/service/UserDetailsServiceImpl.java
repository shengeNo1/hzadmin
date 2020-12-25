package me.shengeNo1.modules.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 深哥哥的小迷妹 liuyuanshenno.1@gmail.com
 * @version 1.0.0
 * @ClassName UserDetailsServiceImpl.java
 * @Description TODO
 * @createTime 2020年12月25日 20:21:00
 */
@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
