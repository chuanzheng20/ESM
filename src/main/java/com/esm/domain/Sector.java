package com.esm.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_sector")
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sector_id", type = IdType.AUTO)
    private Integer sector_id;

    private String sector_name;

    private Integer org_id;


}
