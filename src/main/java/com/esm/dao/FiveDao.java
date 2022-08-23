package com.esm.dao;

import com.esm.domain.Five;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esm.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 五险一金比例表 Mapper 接口
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Mapper
public interface FiveDao extends BaseMapper<Five> {

}
