package com.esm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.esm.controller.Code;
import com.esm.controller.Result;
import com.esm.domain.query.UserQuery;
import com.esm.domain.query.UserRoleQuery;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {


    @Autowired
    private UserService userService;


    @Test
    void testGetLevel(){
        System.out.println(userService.getLevel());
    }

    @Test
    void testGetByPage() throws JSONException {
        UserQuery userQuery = new UserQuery();
        // userQuery.setUserId(1);
        IPage<UserQuery> page = new Page<>(1,3);
        userService.selectByPageAndCurrentPage(page,"001",userQuery.getName(),true);
        JSONObject outData = new JSONObject();
        outData.put("rows",page.getRecords());
        outData.put("totalCount",page.getSize());


        Integer code = page != null ? Code.GET_OK : Code.GET_ERR;
        String msg = page != null ? "" : "用户信息错误，请重试！";

        System.out.println(outData);
    }
    @Test
    void testGetAll(){
        System.out.println(userService.getAll());
    }
    @Test
    void testSelectById(){
        System.out.println(userService.selectById("12345001"));
    }


    @Test
    void testGetByPageRole() throws JSONException {
        UserRoleQuery userRoleQuery = new UserRoleQuery();


        // userQuery.setUserId(1);
        IPage<UserRoleQuery> page = new Page<>(1,3);
        userService.selectByPageAndCurrentPageRole(page,userRoleQuery.getUserId(),userRoleQuery.getName(),true);
        JSONObject outData = new JSONObject();
        outData.put("rows",page.getRecords());
        outData.put("totalCount",page.getSize());


        Integer code = page != null ? Code.GET_OK : Code.GET_ERR;
        String msg = page != null ? "" : "用户信息错误，请重试！";

        System.out.println(outData);
    }
}
