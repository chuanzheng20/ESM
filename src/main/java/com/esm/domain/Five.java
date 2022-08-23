package com.esm.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 五险一金比例表
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_five")
public class Five implements Serializable {

    @TableId(value = "five_id", type = IdType.AUTO)
    private Integer fiveId;


    private Integer yMId;

    private Double endowment;

    private Double maternity;

    private Double medical;

    private Double employment;

    private Double unemployment;

    private Double housing;
//测试1

}
