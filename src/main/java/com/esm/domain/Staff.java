package com.esm.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("tb_staff")
public class Staff implements Serializable {


    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private Integer userId;

    private String password;

    private String name;

    private String sex;

    private LocalDateTime birthday;

    private String tel;

    private String email;

    private String address;

    @TableField("create_date")
    private LocalDateTime createDate;

    private Integer roleId;

    private Integer gradedId;

    @TableLogic
    private Integer deleted;


}
