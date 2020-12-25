package me.shengeNo1.modules.system.service.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 深哥哥的小迷妹 liuyuanshenno.1@gmail.com
 * @version 1.0.0
 * @ClassName UserDto.java
 * @Description TODO
 * @createTime 2020年12月25日 19:53:00
 */
@Data
public class UserDto implements Serializable {

    private Long id;

//    private Set<RoleSmallDto> roles;
//
//    private Set<JobSmallDto> jobs;
//
    private DeptSmallDto dept;

    private Long deptId;

    private String username;

    private String nickName;

    private String email;

    private String phone;

    private String gender;

    private String avatarName;

    private String avatarPath;

    @JSONField(serialize = false)
    private String password;

    private Boolean enabled;

    @JSONField(serialize = false)
    private Boolean isAdmin = false;

    private Date pwdResetTime;

}
