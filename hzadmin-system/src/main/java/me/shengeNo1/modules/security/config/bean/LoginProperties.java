package me.shengeNo1.modules.security.config.bean;

import com.wf.captcha.*;
import com.wf.captcha.base.Captcha;
import lombok.Data;
import me.shengeNo1.utils.StringUtils;

import java.awt.*;
import java.util.Objects;

/**
 * @author LYS liuyua776@gmail.com
 * @version 1.0.0
 * @ClassName LoginProperties.java
 * @Description TODO
 * @createTime 2020年12月25日 11:08:00
 */
@Data
public class LoginProperties {
    /**
     * 账号单用户 登录
     */
    private boolean singleLogin = false;

    private LoginCode loginCode;
    /**
     * 用户登录信息缓存
     */
    private boolean cacheEnable;

    public boolean isCacheEnable() {
        return cacheEnable;
    }

    /**
     * 获取验证码生产类
     *
     * @return /
     */
    public Captcha getCaptcha() throws Exception {
        if (Objects.isNull(loginCode)) {
            loginCode = new LoginCode();
            if (Objects.isNull(loginCode.getCodeType())) {
                loginCode.setCodeType(LoginCodeEnum.arithmetic);
            }
        }
        return switchCaptcha(loginCode);
    }

    /**
     * 依据配置信息生产验证码
     *
     * @param loginCode 验证码配置信息
     * @return /
     */
    private Captcha switchCaptcha(LoginCode loginCode) throws Exception {
        Captcha captcha;
        synchronized (this) {
            switch (loginCode.getCodeType()) {
                case arithmetic:
                    // 算术类型 https://gitee.com/whvse/EasyCaptcha
                    captcha = new ArithmeticCaptcha(loginCode.getWidth(), loginCode.getHeight());
                    // 几位数运算，默认是两位
                    captcha.setLen(loginCode.getLength());
                    break;
                case chinese:
                    captcha = new ChineseCaptcha(loginCode.getWidth(), loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                case chinese_gif:
                    captcha = new ChineseGifCaptcha(loginCode.getWidth(), loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                case gif:
                    captcha = new GifCaptcha(loginCode.getWidth(), loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                case spec:
                    captcha = new SpecCaptcha(loginCode.getWidth(), loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                default:
                    throw new Exception("验证码配置信息错误！正确配置查看 LoginCodeEnum ");
            }
        }
        if(StringUtils.isNotBlank(loginCode.getFontName())){
            captcha.setFont(new Font(loginCode.getFontName(), Font.PLAIN, loginCode.getFontSize()));
        }
        return captcha;
    }


}
