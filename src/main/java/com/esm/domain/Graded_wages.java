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
 * 员工级别工资表
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_graded_wages")
public class Graded_wages implements Serializable {


    @TableId(value = "graded_id", type = IdType.AUTO)
    private Integer gradedId;

    @TableField("sector_id")
    private Integer sectorId;

    @TableField("graded_name")
    private String gradedName;

    private Double money;


}
