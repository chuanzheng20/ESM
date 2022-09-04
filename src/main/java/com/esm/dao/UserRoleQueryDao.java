package com.esm.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.domain.query.UserQuery;
import com.esm.domain.query.UserRoleQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface UserRoleQueryDao extends BaseMapper<UserRoleQuery> {

    /**
     * 动态查询
     */
    @Select("SELECT user_id, name, sex, birthday, tel, email, address, create_date, tb_user.role_id, graded_id, deleted, role_name, power" +
            " FROM  tb_user, tb_role" +
            " ${ew.customSqlSegment} ")
    IPage<UserRoleQuery> findByPage(IPage<UserRoleQuery> page, @Param("ew") Wrapper wrapper);


    /**
     * 动态查询
     */
    @Select("SELECT user_id, name, sex, birthday, tel, email, address, create_date, tb_user.role_id, graded_id, deleted, role_name, power" +
            " FROM  tb_user, tb_role" +
            " ${ew.customSqlSegment} ")
    UserRoleQuery findById(@Param("ew") Wrapper wrapper);
}
