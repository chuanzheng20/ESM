package com.esm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.dao.GradedWagesDao;
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

    @Autowired
    private GradedWagesDao gradedWagesDao;
    @Override
    public boolean save(GradedWages gradedWages) {
        int i = gradedWagesDao.insert(gradedWages);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(Integer gradedWagesId) {
        int i = gradedWagesDao.deleteById(gradedWagesId);

        if (i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(List<String> ids) {
        int i = gradedWagesDao.deleteBatchIds(ids);

        if (i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(GradedWages gradedWages) {
        int i = gradedWagesDao.updateById(gradedWages);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public GradedWages getById(Integer gradedWagesId) {

        return gradedWagesDao.selectById(gradedWagesId);
    }

    @Override
    public List<GradedWages> getAll() {
        return gradedWagesDao.selectList(null);
    }

    @Override
    public IPage<GradedWagesQuery> selectByPageAndCurrentPage(IPage<GradedWagesQuery> page, String gradedName, List<String> sectorIds, Boolean isAse){

        QueryWrapper<UserRoleQuery> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(sectorIds.size()>0,"tb_graded_wages.sector_id",sectorIds);
        queryWrapper.like(StringUtils.hasText(gradedName), "tb_graded_wages.graded_name", gradedName);
        queryWrapper.apply("tb_graded_wages.sector_id = tb_sector.sector_id");
        queryWrapper.orderBy(true,isAse,"tb_graded_wages.graded_id");

        gradedWagesQueryDao.findByPage(page, queryWrapper);
        return page;
    }


}
