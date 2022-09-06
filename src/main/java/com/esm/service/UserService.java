package com.esm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.esm.domain.Level;
import com.esm.domain.User;
import com.esm.domain.query.UserQuery;
import com.esm.domain.query.UserRoleQuery;

import java.util.List;


public interface UserService {
    /**
     * 按id查询用户表
     * @param id
     * @return
     */
    public User getById(String id);

    /**
     * 获取（分类好的级别数据）
     * @return
     */
    public List<Level> getLevel();

    /**
     * 添加用户
     * @param user
     * @return
     */
    public boolean save(User user);

    /**
     * 按id数据删除用户
     * @param ids id数组
     * @return
     */
    public boolean delete(List<String> ids);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public boolean update(User user);

    /**
     * 查询全部用户信息
     * @return
     */
    public List<User> getAll();

    /**
     * 分页查询（用户表，级别表，部门表）关系表
     * @param page UserQuery分页
     * @param userId 模糊筛选UserId
     * @param name 模糊筛选的name
     * @param isAse 是否按UserId Ase排序
     * @return 查询后的UserQuery分页对象
     */
    public IPage<UserQuery> selectByPageAndCurrentPage(IPage<UserQuery> page, String userId, String name,Boolean isAse);

    /**
     * 按UserId 查询（用户表，级别表，部门表）关系表
     * @param id UserId
     * @return UserQuery对象
     */
    public UserQuery selectById(String id);
    public List<UserQuery> selectAll();
    public List<UserQuery> selectId(String userId);

    /**
     * 分页查询（用户表，角色表）关系表
     * @param page UserRoleQuery分页
     * @param userId 模糊筛选UserId
     * @param name 模糊筛选的name
     * @param isAse 是否按UserId Ase排序
     * @return 查询后的UserRoleQuery分页对象
     */
    public IPage<UserRoleQuery> selectByPageAndCurrentPageRole(IPage<UserRoleQuery> page, String userId, String name, Boolean isAse);

    /**
     * 按UserId 查询（用户表，角色表）关系表
     * @param id UserId
     * @return 查询后的UserRoleQuery分页对象
     */
    public UserRoleQuery selectByIdRole(String id);

    /**
     * 按UserId 查询（用户表，角色表,级别表，部门表）关系表
     * @param userId
     * @return
     */
    public UserQuery selectByIdAndRole(String userId);
}
