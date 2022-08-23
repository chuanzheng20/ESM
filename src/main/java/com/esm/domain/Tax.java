package com.esm.domain;

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

    private static final long serialVersionUID = 1L;

    private Integer tax_id;

    private String start_m;

    private String end_m;

    private String tax_rate;


}
