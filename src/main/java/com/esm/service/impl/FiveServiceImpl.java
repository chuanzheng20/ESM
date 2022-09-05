package com.esm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.controller.Code;
import com.esm.dao.FiveDao;
import com.esm.dao.FiveQueryDao;
import com.esm.domain.Five;
import com.esm.domain.query.FiveQuery;
import com.esm.exception.BusinessException;
import com.esm.service.FiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/8/30 17:45
 * @Version 1.0
 */
@Service
public class FiveServiceImpl implements  FiveService {
    @Autowired
    private FiveQueryDao fiveQueryDao;
    @Autowired
    private FiveDao fiveDao;


    @Override
    public IPage<FiveQuery> selectByPageAndCurrentPage(IPage<FiveQuery> page,String userId, Boolean isAse) {
        QueryWrapper<FiveQuery> queryWrapper=new QueryWrapper<>();
        queryWrapper.apply("tb_y_m.y_m_id=tb_wages.y_m_id")
                .apply("tb_wages.y_m_id=tb_five.y_m_id")
                .apply("tb_wages.five_id=tb_five.five_id")
                .apply("tb_wages.user_id=tb_user.user_id")
                .apply(" tb_user.graded_id=tb_graded_wages.graded_id");
        queryWrapper.like(StringUtils.hasText(userId), "tb_wages.user_id", userId);
        queryWrapper.orderBy(true,isAse,"tb_wages.user_id");
        return fiveQueryDao.findByPage(page,queryWrapper);
    }

    @Override
    public List<Five> selectById(Integer yMId) {
        QueryWrapper<Five> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("tb_five.y_m_id",yMId);
        return fiveDao.selectById(queryWrapper);
    }

    @Override
    public IPage<Five> selectByPageAndCurrentPages(IPage<Five> page, Boolean isAse) {
        QueryWrapper<FiveQuery> queryWrapper=new QueryWrapper<>();
        queryWrapper.apply("tb_five.y_m_id=tb_y_m.y_m_id");
        queryWrapper.orderBy(true,isAse,"tb_five.five_id");
        return fiveDao.findByPage(page,queryWrapper);
    }

    @Override
    public List<Five> selectByIds(Integer fiveId) {
        QueryWrapper<Five> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("tb_five.five_id",fiveId);
        return fiveDao.selectById(queryWrapper);
    }

    @Override
    public boolean save(Five five) {
        int insert = fiveDao.insert(five);
        if (insert > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Integer fiveId) {
        try {
            int i = fiveDao.deleteById(fiveId);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }catch (Exception ex){
            throw new BusinessException(Code.BUSINESS_ERR, "该表有被使用，不可删除");
        }

    }

    @Override
    public boolean update(Five five) {
        return false;
    }

    @Override
    public Five getById(Integer fiveId) {
        return null;
    }

    @Override
    public List<Five> getAll() {
        return null;
    }


}
