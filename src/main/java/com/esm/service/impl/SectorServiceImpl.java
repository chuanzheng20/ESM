package com.esm.service.impl;

import com.esm.dao.OrgDao;
import com.esm.dao.SectorDao;
import com.esm.domain.Org;
import com.esm.domain.Sector;
import com.esm.service.OrgService;
import com.esm.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorServiceImpl implements SectorService {

    @Autowired
    private SectorDao sectorDao;

    @Override
    public boolean save(Sector sector) {
        int insert = sectorDao.insert(sector);
        if (insert > 0) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public boolean delete(Integer sectorId) {

        int i = sectorDao.deleteById(sectorId);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Sector sector) {
        int i = sectorDao.updateById(sector);

        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Sector getById(Integer sectorId) {
        Sector sector = sectorDao.selectById(sectorId);

        return sector;
    }

    @Override
    public List<Sector> getAll() {
        List<Sector> sectors = sectorDao.selectList(null);
        return sectors;
    }

}