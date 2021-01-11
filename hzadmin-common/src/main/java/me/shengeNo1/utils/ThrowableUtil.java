package me.shengeNo1.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName ThrowableUtil.java
 * @Description TODO
 * @createTime 2021年01月02日 17:28:00
 */

public class ThrowableUtil {

    /**
     * 获取堆栈信息
     */
    public static String getStackTrace(Throwable throwable){
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }

}
