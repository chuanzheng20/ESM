package com.esm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esm.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
