package com.esm.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.domain.query.GradedWagesQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 员工级别工资表联部门表 Mapper 接口
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-09-04
 */
@Mapper
public interface GradedWagesQueryDao extends BaseMapper<GradedWagesQuery> {

    /**
     * 动态查询
     */
    @Select("SELECT * " +
            " FROM tb_graded_wages, tb_sector" +
            " ${ew.customSqlSegment} ")
    IPage<GradedWagesQuery> findByPage(IPage<GradedWagesQuery> page, @Param("ew") Wrapper wrapper);


    /**
     * 动态查询
     */
    @Select("SELECT * " +
            " FROM tb_graded_wages, tb_sector" +
            " ${ew.customSqlSegment} ")
    GradedWagesQuery findById(@Param("ew") Wrapper wrapper);


}
