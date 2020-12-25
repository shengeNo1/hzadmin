package me.shengeNo1.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.shengeNo1.utils.enums.ServiceError;

/**
 * @author LYS liuyua776@gmail.com
 * @version 1.0.0
 * @ClassName GenericResponse.java
 * @Description TODO
 * @createTime 2020年12月25日 15:37:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GenericResponse {
    private boolean success;
    private int statusCode;
    private String msg;
    private Object content;

    public static GenericResponse response(ServiceError error) {
        return GenericResponse.response(error,null);
    }

    public static GenericResponse response(ServiceError error, Object data) {
        if (error == null){
            error = ServiceError.UN_KNOW_ERROR;
        }
        if (error.equals(ServiceError.OK)){
            return new GenericResponse(true, error.getCode(), error.getMsg(), data);
        }
        return new GenericResponse(false, error.getCode(), error.getMsg(), data);
    }

    public static GenericResponse ok(Object content){
        return GenericResponse.response(true, ServiceError.OK.getCode(), ServiceError.OK.getMsg(), content);
    }

    public static GenericResponse vf(Object content){
        return GenericResponse.response(false, ServiceError.VERIFICATION_FAIL.getCode(), ServiceError.VERIFICATION_FAIL.getMsg(), content);
    }

    private static GenericResponse response(Boolean success, int statusCode, String msg, Object content){
        return  new GenericResponse(success, statusCode, msg, content);
    }
}
