package com.esm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.dao.GradedWagesQueryDao;
import com.esm.domain.GradedWages;
import com.esm.domain.Sector;
import com.esm.domain.query.GradedWagesQuery;
import com.esm.domain.query.UserRoleQuery;
import com.esm.service.GradedWagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class GradedWagesServiceImpl implements GradedWagesService {

    @Autowired
    private GradedWagesQueryDao gradedWagesQueryDao;

    @Override
    public boolean save(GradedWages gradedWages) {
        return false;
    }

    @Override
    public boolean delete(Integer gradedWagesId) {
        return false;
    }

    @Override
    public boolean update(GradedWages gradedWages) {
        return false;
    }

    @Override
    public GradedWages getById(Integer gradedWagesId) {
        return null;
    }

    @Override
    public List<GradedWages> getAll() {
        return null;
    }

    @Override
    public IPage<GradedWagesQuery> selectByPageAndCurrentPage(IPage<GradedWagesQuery> page, String gradedName, String sectorId, Boolean isAse){

        QueryWrapper<UserRoleQuery> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(StringUtils.hasText(sectorId),"tb_graded_wages.sector_id",sectorId);
        queryWrapper.like(StringUtils.hasText(gradedName), "tb_user.name", gradedName);
        queryWrapper.apply("tb_graded_wages.sector_id = tb_sector.sector_id");
        queryWrapper.orderBy(true,isAse,"tb_graded_wages.graded_id");

        gradedWagesQueryDao.findByPage(page, queryWrapper);
        return page;
    }


}
