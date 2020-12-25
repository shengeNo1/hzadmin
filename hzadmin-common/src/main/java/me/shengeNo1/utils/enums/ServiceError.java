package me.shengeNo1.utils.enums;

/**
 * @author LYS liuyua776@gmail.com
 * @version 1.0.0
 * @ClassName ServiceError.java
 * @Description TODO
 * @createTime 2020年12月25日 15:41:00
 */
public enum ServiceError {

    /**
     * 请求成功
     */
    OK(20000, "操作成功"),
    UN_KNOW_ERROR(-20000, "未知错误"),
    VERIFICATION_FAIL(20001, "验证失败");



    private Integer code;
    private String msg;


    private ServiceError( Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
