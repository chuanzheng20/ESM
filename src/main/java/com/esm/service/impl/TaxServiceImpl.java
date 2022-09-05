package com.esm.service.impl;

import com.esm.dao.TaxDao;
import com.esm.domain.Sector;
import com.esm.domain.Tax;
import com.esm.service.TaxService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/9/5 10:31
 * @Version 1.0
 */
@Service
public class TaxServiceImpl implements TaxService {
    @Autowired
    private TaxDao taxDao;
    @Override
    public boolean save(Tax tax) {
        return false;
    }

    @Override
    public boolean delete(Integer taxId) {
        return false;
    }

    @Override
    public boolean update(Tax tax) {
        return false;
    }

    @Override
    public Tax getById(Integer taxId) {
        return null;
    }

    @Override
    public List<Tax> getAll() {
        List<Tax> taxes = taxDao.selectList(null);
        return taxes;
    }
}
