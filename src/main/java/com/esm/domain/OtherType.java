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
public class OtherType implements Serializable {

    @TableId(value = "other_type_id")
    private Integer otherTypeId;

    @TableField("y_m_id")
    private Integer yMId;

    private String name;

    private Double money;

    @Override
    public String toString() {
        return "OtherType{" +
                "\"otherTypeId\":" + otherTypeId +
                ", \"yMId\":" + yMId +
                ", \"name\":'" + name + '\'' +
                ", \"money\":" + money +
                '}';
    }
}
