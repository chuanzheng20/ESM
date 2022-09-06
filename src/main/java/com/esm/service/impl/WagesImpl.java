package com.esm.service.impl;

import com.esm.dao.WagesDao;
import com.esm.dao.WagesQueryDao;
import com.esm.domain.Wages;
import com.esm.service.WagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/9/1 8:13
 * @Version 1.0
 */
@Service
@Transactional
public class WagesImpl implements WagesService {

    @Autowired
    private WagesQueryDao wagesQueryDao;
    @Autowired
    private WagesDao wagesDao;

    @Override
    public boolean save(Wages wages) {
        int insert = wagesDao.insert(wages);
        if (insert > 0) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public boolean delete(Integer wagesId) {
        return false;
    }

    @Override
    public boolean update(Wages wages) {
        return false;
    }

    @Override
    public Wages getById(Integer wagesId) {
        return null;
    }

    @Override
    public List<Wages> getAll() {
        return null;
    }

//    @Override
//    public List<WagesQuery> selectById(String userId) {
//        QueryWrapper<WagesQuery> queryWrapper=new QueryWrapper<>();
//        queryWrapper.in("tb_wages.user_id",userId);
//        queryWrapper.apply("tb_wages.user_id=tb_user.user_id")
//                    .apply("tb_graded_wages.graded_id=tb_user.graded_id")
//                    .apply("tb_wages.y_m_id=tb_y_m.y_m_id");
//        return  wagesQueryDao.findById(queryWrapper);
//    }

}
