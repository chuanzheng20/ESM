package com.esm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.domain.GradedWages;
import com.esm.domain.query.GradedWagesQuery;

import java.util.List;

public interface GradedWagesService {
    public boolean save(GradedWages gradedWages);
    public boolean delete(Integer gradedWagesId);
    public boolean delete(List<String> ids);
    public boolean update(GradedWages gradedWages);
    public GradedWages getById(Integer gradedWagesId);
    public List<GradedWages> getAll();

    public IPage<GradedWagesQuery> selectByPageAndCurrentPage(IPage<GradedWagesQuery> page, String gradedName, List<String> sectorIds, Boolean isAse);

}
