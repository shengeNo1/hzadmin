package me.shengeNo1.modules.security.service;

import me.shengeNo1.utils.StringUtils;

/**
 * @author 深哥哥的小迷妹 liuyuanshenno.1@gmail.com
 * @version 1.0.0
 * @ClassName UserCacheClean.java
 * @Description TODO
 * @createTime 2020年12月25日 20:20:00
 */
public class UserCacheClean {

    /**
     * 清理特定用户缓存信息<br>
     * 用户信息变更时
     *
     * @param userName /
     */
    public void cleanUserCache(String userName) {
        if (StringUtils.isNotEmpty(userName)) {
//            UserDetailsServiceImpl.userDtoCache.remove(userName);
        }
    }

    /**
     * 清理所有用户的缓存信息<br>
     * ,如发生角色授权信息变化，可以简便的全部失效缓存
     */
    public void cleanAll() {
//        UserDetailsServiceImpl.userDtoCache.clear();
    }

}
