package me.shengeNo1.modules.security.service.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 深哥哥的小迷妹 liuyuanshenno.1@gmail.com
 * @version 1.0.0
 * @ClassName AuthUserDto.java
 * @Description TODO
 * @createTime 2020年12月25日 16:51:00
 */
@Data
public class AuthUserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String code;

    private String uuid = "";
}
