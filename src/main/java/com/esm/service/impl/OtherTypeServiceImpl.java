package com.esm.service.impl;

import com.esm.dao.OtherTypeDao;
import com.esm.domain.OtherType;
import com.esm.domain.Sector;
import com.esm.service.OtherTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/9/5 22:21
 * @Version 1.0
 */
@Service
public class OtherTypeServiceImpl implements OtherTypeService {
    @Autowired
    private OtherTypeDao otherTypeDao;
    @Override
    public boolean save(OtherType otherType) {
        int insert = otherTypeDao.insert(otherType);
        if (insert > 0) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public boolean delete(Integer otherTypeId) {
        return false;
    }

    @Override
    public boolean update(OtherType otherType) {
        int i = otherTypeDao.updateById(otherType);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public OtherType getById(Integer otherTypeId) {
        return null;
    }

    @Override
    public List<OtherType> getAll() {
        List<OtherType> otherTypes = otherTypeDao.selectList(null);
        return otherTypes;
    }
}
