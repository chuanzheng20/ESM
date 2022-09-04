package com.esm.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.esm.domain.Role;
import com.esm.domain.Root;
import com.esm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public Result save(@RequestBody Role role){
        boolean flag = roleService.save(role);
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = flag ? "" : "添加角色信息错误，请重试！";
        return new Result(code,null,msg);
    }
    @DeleteMapping("/{roleIds}")
    public Result delete(@PathVariable List<Integer> roleIds) {

        List<Integer> noDeleteIds = Arrays.asList(1, 2, 3);
        for (Integer i: roleIds) {
            if(noDeleteIds.indexOf(i)>0){
                return new Result(Code.DELETE_ERR,null,"默认角色不可删除");
            }
        }
        boolean flag = roleService.delete(roleIds);
        Integer code = flag ? Code.DELETE_OK : Code.DELETE_ERR;
        String msg = flag ? "" : "删除角色信息错误，请重试！";
        return new Result(code,null,msg);
    }

    @PutMapping
    public Result update(@RequestBody Role role) {
        boolean flag = roleService.update(role);
        Integer code = flag ? Code.UPDATE_OK : Code.UPDATE_ERR;
        String msg = flag ? "" : "更新角色信息错误，请重试！";
        return new Result(code,null,msg);
    }

    @GetMapping("/{rootId}")
    public Result getById(@PathVariable Integer rootId) {
        Role data = roleService.getById(rootId);
        Integer code = data != null ? Code.GET_OK : Code.GET_ERR;
        String msg = data != null ? "" : "查询角色信息错误，请重试！";
        return new Result(code,data,msg);

    }
    @GetMapping
    public Result getAll() {
        List<Role> rootList = roleService.getAll();
        Integer code = rootList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = rootList != null ? "" : "查询信息错误，请重试！";
        return new Result(code,rootList,msg);
    }



}
