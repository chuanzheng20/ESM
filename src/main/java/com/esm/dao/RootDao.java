package com.esm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.esm.domain.Root;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RootDao extends BaseMapper<Root> {
}


