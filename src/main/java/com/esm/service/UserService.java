package com.esm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.domain.Level;
import com.esm.domain.User;
import com.esm.domain.query.UserQuery;

import java.util.List;


public interface UserService {
    public User getById(Integer id);
    public List<Level> getLevel();
    public boolean save(User user);
    public boolean delete(Integer userId);
    public boolean update(User user);
    public List<User> getAll();
    public IPage<UserQuery> selectByPageAndCurrentPage(IPage<UserQuery> page, String userId, String name,Boolean isAse);
    public UserQuery selectById(String id);

}
