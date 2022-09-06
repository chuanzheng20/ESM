package com.esm.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.domain.query.FiveQuery;
import com.esm.domain.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/8/30 15:16
 * @Version 1.0
 */
@Mapper
public interface FiveQueryDao extends BaseMapper<FiveQuery> {
    @Select("SELECT tb_wages.user_id,tb_wages.y_m_id,tb_y_m.date,tb_user.name,tb_five.employment,tb_five.endowment,tb_five.housing,tb_five.maternity,tb_five.medical,tb_five.unemployment,tb_graded_wages.money,tb_wages.other_wages,tb_wages.pre_tax,tb_wages.after_tax " +
            " FROM tb_wages,tb_y_m,tb_five,tb_user,tb_graded_wages " +
            " ${ew.customSqlSegment}")
    IPage<FiveQuery> findByPage(IPage<FiveQuery> page, @Param("ew") Wrapper wrapper);
}
