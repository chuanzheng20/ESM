package com.esm.service;

import com.esm.domain.Wages;

import java.util.List;

public interface WagesService {
    public boolean save(Wages wages);
    public boolean delete(Integer wagesId);
    public boolean update(Wages wages);
    public Wages getById(Integer wagesId);
    public List<Wages> getAll();
}
