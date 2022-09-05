package com.esm.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esm.domain.query.OtherDetailsQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/8/30 15:17
 * @Version 1.0
 */
@Mapper
public interface OtherDetailsQueryDao extends BaseMapper<OtherDetailsQuery> {
    @Select("SELECT tb_other_type.`name`,tb_other_type.money,tb_other_details.num " +
            "FROM tb_other_details,tb_wages,tb_other_type " +
            "${ew.customSqlSegment}")
    List<OtherDetailsQuery> findselect(@Param("ew") Wrapper wrapper);

}
