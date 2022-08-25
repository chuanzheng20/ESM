package com.esm.service;

import com.esm.domain.NavData;

import java.util.List;

public interface NavService {
    public List<NavData> getNavByPower(String power);
}
