package com.esm.service;

import com.esm.domain.Level;
import com.esm.domain.User;

import java.util.List;


public interface UserService {
    public User getById(Integer id);
    public List<Level> getLevel();


}
