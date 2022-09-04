package com.esm.service.impl;

import com.esm.controller.Code;
import com.esm.dao.RoleDao;
import com.esm.domain.Role;
import com.esm.exception.BusinessException;
import com.esm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public boolean save(Role role) {
        int i = roleDao.insert(role);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(List<Integer>  roleIds) {
        try {
            int i = roleDao.deleteBatchIds(roleIds);
            if (i>0){
                return true;
            }else {
                return false;
            }
        }catch (Exception ex){
            throw new BusinessException(Code.BUSINESS_ERR, "该角色有被使用，不可删除");
        }
    }

    @Override
    public boolean update(Role role) {

        int i = roleDao.updateById(role);
        if (i>0){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public Role getById(Integer roleId) {
        System.out.println(roleId);
        Role role = roleDao.selectById(roleId);
        System.out.println(role);
        return role;

    }

    @Override
    public List<Role> getAll() {
        List<Role> roles = roleDao.selectList(null);
        return roles;
    }



}
