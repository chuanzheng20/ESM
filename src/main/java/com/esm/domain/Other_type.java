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
 * 其他收入类型表
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_other_type")
public class Other_type implements Serializable {

    @TableId(value = "type_id", type = IdType.ASSIGN_ID)
    private Integer typeId;

    @TableField("y_m_id")
    private Integer yMId;

    private String name;

    private Double money;
//测试4

}
