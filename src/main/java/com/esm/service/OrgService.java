package com.esm.service;

import com.esm.domain.Five;
import com.esm.domain.Org;

import java.util.List;

public interface OrgService {
    public boolean save(Org org);
    public boolean delete(Integer orgId);
    public boolean update(Org org);
    public Org getById(Integer orgId);
    public List<Org> getAll();
}
