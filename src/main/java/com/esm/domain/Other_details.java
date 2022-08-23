package com.esm.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 其他收入明细表
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_other_details")
public class Other_details implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "other_details_id", type = IdType.AUTO)
    private Integer other_details_id;

    private Integer user_id;

    private Integer y_m_id;

    private Integer other_typeid;

    private Integer num;


}
