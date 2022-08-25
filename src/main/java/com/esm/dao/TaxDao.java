package com.esm.dao;

import com.esm.domain.Tax;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 税务表 Mapper 接口
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Mapper
public interface TaxDao extends BaseMapper<Tax> {

}
