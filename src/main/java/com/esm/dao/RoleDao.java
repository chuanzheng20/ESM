package com.esm.dao;

import com.esm.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Mapper
public interface RoleDao extends BaseMapper<Role> {

}
