package com.esm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 税务表
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_tax")
public class Tax implements Serializable {

    @TableId(value = "tax_id", type = IdType.ASSIGN_ID)
    private Integer taxId;

    @TableField("start_m")
    private String startM;

    @TableField("end_m")
    private String endM;

    @TableField("tax_rate")
    private String taxRate;


}
