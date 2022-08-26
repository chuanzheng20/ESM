package com.esm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esm.domain.Sector;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SectorDao extends BaseMapper<Sector> {

    @Select("select * from tb_sector")
    public List<Sector> getAll();


}
