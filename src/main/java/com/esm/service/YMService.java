package com.esm.service;

import com.esm.domain.YM;

import java.util.List;

public interface YMService {
    public boolean save(YM ym);
    public boolean delete(Integer yMId);
    public boolean update(YM ym);
    public YM getById(Integer yMId);
    public List<YM> getAll();
//    [/pages/wagescalculate.html,/wages/selectByPageAndCurrentPage,/wages/selectFive,/wages/timeToAll,/wages/taxRateAll,/wages]
}
