package com.esm.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.domain.query.UserQuery;
import com.sun.org.apache.xpath.internal.operations.Plus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户，部门，级别表 Mapper 接口
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Mapper
public interface UserQueryDao extends BaseMapper<UserQuery> {

    /**
     * 静态查询
     */
    @Select("SELECT * " +
            " FROM  tb_user, tb_graded_wages, tb_sector" +
            " WHERE tb_user.id = #{id} " +
            "     AND t_blog.user_id = t_user.id")
    String findUserNameByBlogId(@Param("id") Long id);

    /**
     * 动态查询
     */
    @Select("SELECT user_id, name, sex, birthday, tel, email, address, create_date, role_id, tb_user.graded_id, deleted, tb_graded_wages.sector_id, graded_name, money, sector_name, org_id " +
            " FROM  tb_user, tb_graded_wages, tb_sector" +
            " ${ew.customSqlSegment} ")
    IPage<UserQuery> findByPage(IPage<UserQuery> page, @Param("ew") Wrapper wrapper);

    /**
     * 动态查询
     */
    @Select("SELECT user_id, name, sex, birthday, tel, email, address, create_date, role_id, tb_user.graded_id, deleted, tb_graded_wages.sector_id, graded_name, money, sector_name, org_id " +
            " FROM  tb_user, tb_graded_wages, tb_sector" +
            " ${ew.customSqlSegment} ")
    UserQuery findById(@Param("ew") Wrapper wrapper);

    /**
     * 查询全部
     */
    @Select("SELECT tb_user.user_id,tb_user.`name`,tb_graded_wages.money " +
            "FROM tb_user,tb_graded_wages " +
            " ${ew.customSqlSegment} ")
    List<UserQuery> findAll(@Param("ew") Wrapper wrapper);

    @Select("SELECT tb_user.user_id,tb_user.`name`,tb_graded_wages.money " +
            "FROM tb_user,tb_graded_wages " +
            " ${ew.customSqlSegment} ")
    List<UserQuery> findId(@Param("ew") Wrapper wrapper);

}
