package com.esm.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.domain.Five;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esm.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
    @Select("SELECT tb_five.* FROM tb_five " +
            "${ew.customSqlSegment}")
    List<Five> selectById(@Param("ew") Wrapper wrapper);

        @Select("SELECT tb_five.five_id,tb_five.employment,tb_five.endowment,tb_five.housing,tb_five.maternity,tb_five.medical,tb_five.unemployment,tb_y_m.date FROM tb_five,tb_y_m " +
            "${ew.customSqlSegment}")
    IPage<Five> findByPage(IPage<Five> page,@Param("ew") Wrapper wrapper);
}
