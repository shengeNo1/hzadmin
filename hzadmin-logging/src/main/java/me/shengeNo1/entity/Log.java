package me.shengeNo1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName Log.java
 * @Description TODO
 * @createTime 2021年01月04日 23:51:00
 */
@Data
@ToString
@TableName(value = "sys_log")
public class Log {

    @TableId(value = "log_id", type = IdType.AUTO)
    private Long id;

    /** 操作用户 */
    private String username;

    /** 描述 */
    private String description;

    /** 方法名 */
    private String method;

    /** 参数 */
    private String params;

    /** 日志类型 */
    private String logType;

    /** 请求ip */
    private String requestIp;

    /** 地址 */
    private String address;

    /** 浏览器  */
    private String browser;

    /** 请求耗时 */
    private Long time;

    /** 异常详细  */
    private byte[] exceptionDetail;

    /** 创建日期 */
    private Timestamp createTime;
}
