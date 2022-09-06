package com.esm.service.impl;

import com.esm.dao.Y_mDao;
import com.esm.domain.Sector;
import com.esm.domain.YM;
import com.esm.service.YMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/9/5 11:19
 * @Version 1.0
 */
@Service
public class YMServiceImpl implements YMService {
    @Autowired
    private Y_mDao y_mDao;
    @Override
    public boolean save(YM ym) {
        return false;
    }

    @Override
    public boolean delete(Integer yMId) {
        return false;
    }

    @Override
    public boolean update(YM ym) {
        return false;
    }

    @Override
    public YM getById(Integer yMId) {
        return null;
    }

    @Override
    public List<YM> getAll() {
        List<YM> yms= y_mDao.selectList(null);
        return yms;
    }
}
