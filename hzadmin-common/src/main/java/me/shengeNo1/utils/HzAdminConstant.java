package me.shengeNo1.utils;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName ElAdminConstant.java
 * @Description TODO
 * @createTime 2021年01月02日 11:11:00
 */

public class HzAdminConstant {
    /**
     * 用于IP定位转换
     */
    public static final String REGION = "内网IP|内网IP";
    /**
     * win 系统
     */
    public static final String WIN = "win";

    /**
     * mac 系统
     */
    public static final String MAC = "mac";

    /**
     * 常用接口
     */
    public static class Url {
        // IP归属地查询
        public static final String IP_URL = "http://whois.pconline.com.cn/ipJson.jsp?ip=%s&json=true";
    }
}
