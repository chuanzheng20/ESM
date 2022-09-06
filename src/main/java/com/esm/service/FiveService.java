package com.esm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.domain.Five;
import com.esm.domain.query.FiveQuery;

import java.util.List;

public interface FiveService {
    //chen
    public IPage<FiveQuery> selectByPageAndCurrentPage(IPage<FiveQuery> page, String userId, Boolean isAse);
    public List<Five> selectById(Integer yMId);
    public IPage<Five> selectByPageAndCurrentPages(IPage<Five> page,Boolean isAse);
    public List<Five> selectByIds(Integer fiveId);

    //yu
    public boolean save(Five five);
    public boolean delete(Integer fiveId);
    public boolean update(Five five);
    public Five getById(Integer fiveId);
    public List<Five> getAll();

}
