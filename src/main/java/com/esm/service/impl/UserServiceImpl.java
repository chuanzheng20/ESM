package com.esm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.esm.dao.*;
import com.esm.domain.GradedWages;
import com.esm.domain.Level;
import com.esm.domain.Sector;
import com.esm.domain.User;
import com.esm.domain.query.UserQuery;
import com.esm.domain.query.UserRoleQuery;
import com.esm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public SectorDao sectorDao;

    @Autowired
    public GradedWagesDao gradedWagesDao;

    @Autowired
    public UserDao userDao;

    @Autowired
    public UserQueryDao userQueryDao;

    @Autowired
    public UserRoleQueryDao userRoleQueryDao;

    @Override
    public User getById(String id) {

        User user = userDao.selectById(id);
        return user;
    }
    @Override
    public boolean save(User user){
        user.setPassword("123456");
        int i = userDao.insert(user);
        return i>0?true:false;
    }

    @Override
    public boolean delete(List<String> ids){
        int i = userDao.deleteBatchIds(ids);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(User user) {
        user.setPassword(null);
        int i = userDao.updateById(user);
        return i>0?true:false;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = userDao.selectList(null);
        return userList;
    }

    @Override
    public IPage<UserRoleQuery> selectByPageAndCurrentPageRole(IPage<UserRoleQuery> page, String userId, String name, Boolean isAse){

        QueryWrapper<UserRoleQuery> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(userId), "tb_user.user_id", userId);
        queryWrapper.like(StringUtils.hasText(name), "tb_user.name", name);
        queryWrapper.apply("tb_user.role_id = tb_role.role_id");
        queryWrapper.orderBy(true,isAse,"tb_user.user_id");
        queryWrapper.in("deleted",0);
        userRoleQueryDao.findByPage(page, queryWrapper);
        return page;
    }

    @Override
    public UserRoleQuery selectByIdRole(String id) {
        QueryWrapper<UserRoleQuery> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("tb_user.user_id",id);
        queryWrapper.apply("tb_user.role_id = tb_role.role_id");
        queryWrapper.in("deleted",0);
        return userRoleQueryDao.findById(queryWrapper);
    }



    @Override
    public IPage<UserQuery> selectByPageAndCurrentPage(IPage<UserQuery> page,String userId, String name, Boolean isAse){

        QueryWrapper<UserQuery> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(userId), "tb_user.user_id", userId);
        queryWrapper.like(StringUtils.hasText(name), "tb_user.name", name);
        queryWrapper.apply("tb_user.graded_id = tb_graded_wages.graded_id");
        queryWrapper.apply("tb_graded_wages.sector_id = tb_sector.sector_id");
        queryWrapper.orderBy(true,isAse,"tb_user.user_id");
        queryWrapper.in("deleted",0);
        userQueryDao.findByPage(page, queryWrapper);

        return page;
    }

    @Override
    public UserQuery selectById(String userId) {

        QueryWrapper<UserQuery> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("tb_user.user_id",userId);
        queryWrapper.apply("tb_user.graded_id = tb_graded_wages.graded_id");
        queryWrapper.apply("tb_graded_wages.sector_id = tb_sector.sector_id");
        queryWrapper.in("deleted",0);
        return userQueryDao.findById(queryWrapper);
    }

    @Override
    public List<UserQuery> selectAll() {
        QueryWrapper<UserQuery> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("tb_user.graded_id=tb_graded_wages.graded_id");
        return userQueryDao.findAll(queryWrapper);
    }

    @Override
    public List<UserQuery> selectId(String userId) {
        QueryWrapper<UserQuery> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("tb_user.graded_id=tb_graded_wages.graded_id");
        queryWrapper.like(StringUtils.hasText(userId), "tb_user.user_id", userId);
        return userQueryDao.findAll(queryWrapper);
    }

    @Override
    public List<Level> getLevel() {
        List<Sector> sectorList = sectorDao.getAll();
        List<GradedWages> gradedWagesList = gradedWagesDao.getAll();
        List<Level> levelList = new ArrayList<>();
        for (Sector sector: sectorList) {
            List<Level> levels = new ArrayList<>();
            for (GradedWages gradedWages : gradedWagesList) {
                if(gradedWages.getSectorId()==sector.getSectorId()){
                    Level level = new Level();
                    level.setValue(gradedWages.getGradedId());
                    level.setLabel(gradedWages.getGradedName());
                    levels.add(level);
                }
            }
            System.out.println(levels);
            if (levels.size()>0){
                Level level = new Level();
                level.setValue(sector.getSectorId());
                level.setLabel(sector.getSectorName());
                level.setChildren(levels);
                levelList.add(level);
            }
        }
        return levelList;
    }




}
