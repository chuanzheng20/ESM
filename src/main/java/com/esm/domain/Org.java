package com.esm.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_org")
public class Org implements Serializable {


    @TableId(value = "org_id", type = IdType.AUTO)
    private Integer orgId;

    @TableField("org_name")
    private String orgName;

    @TableLogic
    private Integer deleted;


}
