package me.shengeNo1.modules.security.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 深哥哥的小迷妹 liuyuanshenno.1@gmail.com
 * @version 1.0.0
 * @ClassName OnlineUserDto.java
 * @Description TODO
 * @createTime 2020年12月25日 20:09:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlineUserDto {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 岗位
     */
    private String dept;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * IP
     */
    private String ip;

    /**
     * 地址
     */
    private String address;

    /**
     * token
     */
    private String key;

    /**
     * 登录时间
     */
    private Date loginTime;
}
