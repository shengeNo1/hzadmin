package me.shengeNo1.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName RequestHolder.java
 * @Description 获取 HttpServletRequest
 * @createTime 2021年01月02日 17:14:00
 */

public class RequestHolder {

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

}
