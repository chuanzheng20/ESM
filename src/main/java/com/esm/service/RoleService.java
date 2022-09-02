package com.esm.service;

import com.esm.domain.Role;

import java.util.List;

public interface RoleService {
    public boolean save(Role role);
    public boolean delete(List<Integer>  roleIds);
    public boolean update(Role role);
    public Role getById(Integer roleId);
    public List<Role> getAll();
}
