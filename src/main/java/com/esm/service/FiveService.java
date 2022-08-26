package com.esm.service;

import com.esm.domain.Five;

import java.util.List;

public interface FiveService {

    public boolean save(Five five);
    public boolean delete(Integer fiveId);
    public boolean update(Five five);
    public Five getById(Integer fiveId);
    public List<Five> getAll();

}
