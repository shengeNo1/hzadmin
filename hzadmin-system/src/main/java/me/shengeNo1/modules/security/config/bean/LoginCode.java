package me.shengeNo1.modules.security.config.bean;

import lombok.Data;

/**
 * @author LYS liuyua776@gmail.com
 * @version 1.0.0
 * @ClassName LoginCode.java
 * @Description TODO
 * @createTime 2020年12月25日 11:10:00
 */
@Data
public class LoginCode {

    /**
     * 验证码配置
     */
    private LoginCodeEnum codeType;
    /**
     * 验证码有效期 分钟
     */
    private Long expiration = 2L;
    /**
     * 验证码内容长度
     */
    private int length = 2;
    /**
     * 验证码宽度
     */
    private int width = 111;
    /**
     * 验证码高度
     */
    private int height = 36;
    /**
     * 验证码字体
     */
    private String fontName;
    /**
     * 字体大小
     */
    private int fontSize = 25;

    public LoginCodeEnum getCodeType() {
        return codeType;
    }

}
