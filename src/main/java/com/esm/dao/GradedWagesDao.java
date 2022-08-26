package com.esm.dao;

import com.esm.domain.GradedWages;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esm.domain.Sector;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 员工级别工资表 Mapper 接口
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Mapper
public interface GradedWagesDao extends BaseMapper<GradedWages> {
    @Select("select * from tb_graded_wages")
    public List<GradedWages> getAll();
}
