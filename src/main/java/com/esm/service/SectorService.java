package com.esm.service;

import com.esm.domain.Root;
import com.esm.domain.Sector;

import java.util.List;

public interface SectorService {
    public boolean save(Sector sector);
    public boolean delete(Integer sectorId);
    public boolean update(Sector sector);
    public Sector getById(Integer sectorId);
    public List<Sector> getAll();




}
