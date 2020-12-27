package me.shengeNo1.modules.system.service.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class User {
    private String userId;

    private String username;

    private String nickName;

    private String gender;

    private String phone;

    private String email;

    private String avatarName;

    private String avatarPath;

    private String password;

    private Integer isAdmin;

    private String createBy;

    private Date createTime;

    private Date updateTime;
}