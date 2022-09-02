package com.esm.service;

import com.esm.domain.Root;
import com.esm.domain.query.RootQuery;

import java.util.List;

public interface RootService {
    public boolean save(Root root);
    public boolean delete(Integer rootId);
    public boolean update(Root root);
    public Root getById(Integer rootId);
    public List<Root> getAll();
    public List<RootQuery> getToLevelAll();
}
