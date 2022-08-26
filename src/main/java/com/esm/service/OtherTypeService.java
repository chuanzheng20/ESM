package com.esm.service;

import com.esm.domain.OtherType;

import java.util.List;

public interface OtherTypeService {
    public boolean save(OtherType otherType);
    public boolean delete(Integer otherTypeId);
    public boolean update(OtherType otherType);
    public OtherType getById(Integer otherTypeId);
    public List<OtherType> getAll();
}
