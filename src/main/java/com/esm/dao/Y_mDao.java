package com.esm.dao;

import com.esm.domain.YM;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 年月时间表 Mapper 接口
 * </p>
 *
 * @author 俞剑辉
 * @since 2022-08-23
 */
@Mapper
public interface Y_mDao extends BaseMapper<YM> {
    @Select("SELECT tb_y_m.y_m_id,tb_y_m.date FROM tb_y_m order by tb_y_m.date desc ")
    List<YM> selecttime();

}
