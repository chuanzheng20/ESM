package com.esm.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 员工信息表
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user")
public class User implements Serializable {

    @TableId(value = "user_id", type = IdType.ASSIGN_UUID)
    private String userId;
    @TableField(select = false)
    private String password;

    private String name;

    private String sex;

    private Date birthday;

    private String tel;

    private String email;

    private String address;

    private Date createDate;

    private Integer roleId;

    private Integer gradedId;

    @TableLogic
    private Integer deleted;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                ", roleId=" + roleId +
                ", gradedId=" + gradedId +
                ", deleted=" + deleted +
                '}';
    }
}
