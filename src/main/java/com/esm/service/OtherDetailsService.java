package com.esm.service;

import com.esm.domain.OtherDetails;

import java.util.List;

public interface OtherDetailsService {
    public boolean save(OtherDetails otherDetails);
    public boolean delete(Integer otherDetailsId);
    public boolean update(OtherDetails otherDetails);
    public OtherDetails getById(Integer otherDetailsId);
    public List<OtherDetails> getAll();
}
