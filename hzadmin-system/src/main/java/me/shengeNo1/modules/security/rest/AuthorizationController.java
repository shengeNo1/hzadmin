package me.shengeNo1.modules.security.rest;

import cn.hutool.core.util.IdUtil;
import com.wf.captcha.base.Captcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.shengeNo1.config.RsaProperties;
import me.shengeNo1.modules.security.config.bean.LoginCodeEnum;
import me.shengeNo1.modules.security.config.bean.LoginProperties;
import me.shengeNo1.modules.security.config.bean.SecurityProperties;
import me.shengeNo1.modules.security.service.dto.AuthUserDto;
import me.shengeNo1.utils.GenericResponse;
import me.shengeNo1.utils.RedisUtils;
import me.shengeNo1.utils.RsaUtils;
import me.shengeNo1.utils.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author LYS liuyua776@gmail.com
 * @version 1.0.0
 * @ClassName AuthorizationController.java
 * @Description TODO
 * @createTime 2020年12月24日 20:32:00
 */
@Controller
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value ="/auth")
@Api(tags = "系统：系统授权接口")
public class AuthorizationController {
    private final SecurityProperties properties;
    private final RedisUtils redisUtils;
    @Resource
    private LoginProperties loginProperties;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @ApiOperation("获取验证码")
    @GetMapping("/code")
    public GenericResponse getCode() throws Exception {
        Captcha captcha = loginProperties.getCaptcha();
        String uuid = properties.getCodeKey() + IdUtil.simpleUUID();
        //当验证码类型为 arithmetic时且长度 >= 2 时，captcha.text()的结果有几率为浮点型

        String captchaValue = captcha.text();

        if (captcha.getCharType() - 1 == LoginCodeEnum.arithmetic.ordinal() && captchaValue.contains(".")) {
            captchaValue = captchaValue.split("\\.")[0];
        }
        // 保存
        redisUtils.set(uuid, captchaValue, loginProperties.getLoginCode().getExpiration(), TimeUnit.MINUTES);
        Map<String, Object> imgResult = new HashMap<
                String, Object>(2) {{
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        return GenericResponse.ok(imgResult);
    }

    @PostMapping(value = "/login")
    @ApiOperation("登录授权")
    public GenericResponse login(@Validated @RequestBody AuthUserDto authUserDto) throws Exception {
        // 解密密码
        String password = RsaUtils.decryptByPrivateKey(RsaProperties.privateKey, authUserDto.getPassword());
        // 查询验证码
        String code = (String)redisUtils.get(authUserDto.getUuid());
        // 清除验证码
        redisUtils.del(authUserDto.getUuid());
        if (StringUtils.isBlank(code)){
            return GenericResponse.vf("验证码不存在或已过期");
        }
        if (StringUtils.isBlank(authUserDto.getCode()) || !authUserDto.getCode().equalsIgnoreCase(code)){
            return GenericResponse.vf("验证码错误");
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authUserDto.getUsername(),password);
        Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        System.out.println(authenticate);
        return null;
    }
}
