package me.shengeNo1.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName BadRequestException.java
 * @Description TODO
 * @createTime 2021年01月02日 17:30:00
 */
@Getter
public class BadRequestException extends RuntimeException {

    private Integer status = BAD_REQUEST.value();

    public BadRequestException(String msg){
        super(msg);
    }

    public BadRequestException(HttpStatus status, String msg){
        super(msg);
        this.status = status.value();
    }

}
