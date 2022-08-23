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
 * 员工工资表
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_wages")
public class Wages implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer yMId;

    private Integer fiveId;

    @TableField("other_wages")
    private Double otherWages;

    @TableField("pre_tax")
    private Double preTax;

    @TableField("after_tax")
    private Double afterTax;

    private Integer delete;


}
