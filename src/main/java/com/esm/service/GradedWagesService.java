package com.esm.service;

import com.esm.domain.GradedWages;

import java.util.List;

public interface GradedWagesService {
    public boolean save(GradedWages gradedWages);
    public boolean delete(Integer gradedWagesId);
    public boolean update(GradedWages gradedWages);
    public GradedWages getById(Integer gradedWagesId);
    public List<GradedWages> getAll();
}
