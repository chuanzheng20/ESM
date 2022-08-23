package com.esm.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 年月时间表
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_y_m")
public class Y_m implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "y_m_id", type = IdType.AUTO)
    private Integer yMId;

    @TableField("y_m")
    private String yM;

    private LocalDate date;


}
