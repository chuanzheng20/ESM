package com.esm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.esm.dao.UserDao;
import com.esm.domain.User;
import com.esm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;


    @Override
    public User Login(User user) {
        // System.out.println(user);
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        // 等同于=
        lqw.eq(User::getUserId,user.getUserId()).eq(User::getPassword,user.getPassword());
        User loginUser = userDao.selectOne(lqw);
        // System.out.println(loginUser);
        return loginUser;

    }
}
