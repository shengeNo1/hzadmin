package me.shengeNo1.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author 深哥哥的小迷妹 liuyuanshenno.1@gmail.com
 * @version 1.0.0
 * @ClassName ThrowableUtil.java
 * @Description 异常处理工具
 * @createTime 2020年12月28日 19:40:00
 */
public class ThrowableUtil {
    /**
     * 获取堆栈信息
     * @param throwable
     */
    public static String getStackTrace(Throwable throwable){
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }
}
