package com.esm.service;

import com.esm.domain.Sector;
import com.esm.domain.Tax;

import java.util.List;

public interface TaxService {
    public boolean save(Tax tax);
    public boolean delete(Integer taxId);
    public boolean update(Tax tax);
    public Tax getById(Integer taxId);
    public List<Tax> getAll();
}
