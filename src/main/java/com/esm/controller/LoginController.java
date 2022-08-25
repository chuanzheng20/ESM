package com.esm.controller;

import com.esm.domain.NavData;
import com.esm.domain.NavDataItem;
import com.esm.domain.User;
import com.esm.service.LoginService;
import com.esm.service.NavService;
import com.esm.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private NavService navService;
    @Value("${key}")
    private String  key;

    @PostMapping("/login")
    public Result Login(HttpServletResponse response, @RequestBody User user) throws IOException {

        User loginUser = loginService.Login(user);
        Integer code = loginUser != null ? Code.GET_OK : Code.GET_ERR;
        String msg = loginUser != null ? "" : "用户名或密码错误，请重试！";
        if (loginUser!=null){
            String token = JWTUtil.createToken(loginUser.getUserId(),loginUser.getName(), loginUser.getRoleId(),key,3600);
            response.addHeader("Set-Cookie", String.format("%s; %s",
                    String.format("token=%s; Max-Age=%s; Path=/;%s HttpOnly", token, 3600, " Secure;"), "SameSite=None"));
        }
        Result result = new Result(code, loginUser, msg);
        result.setUrl("/pages/ESM.html");
        return result;
    }

    @GetMapping("/logout")
    public Result out(HttpServletResponse response) throws IOException {

        Result result = new Result(Code.GET_OK , null, "退出登录成功");

        result.setUrl("/pages/login.html");

        response.setHeader("Set-Cookie", String.format("%s; %s",
                String.format("token=; Max-Age=%s; Path=/;%s HttpOnly", 3600, " Secure;"), "SameSite=None"));
        return result;
    }

    @GetMapping("/getNavData")
    public Result getNavData(@CookieValue("token") Cookie cookie){

        System.out.println(cookie.getValue());
        String token = cookie.getValue();
        Claims claims = JWTUtil.parseToken(token, key);

        Integer roleId = (Integer) claims.get("roleId");
        System.out.println(claims);
        System.out.println(roleId);
        List<NavData> data = navService.getNavByRoleId(roleId);
        //
        // NavDataItem navDataItem = new NavDataItem("1-1","系统概述","system.html");
        // ArrayList<NavDataItem> navDataItems = new ArrayList<>();
        // navDataItems.add(navDataItem);
        // NavData navData = new NavData("1","系统概述","icon iconfont icon-xitongyunzhuanqingkuang",navDataItems);
        // data.add(navData);
        //
        // NavDataItem navDataItem1 = new NavDataItem("2-1","员工信息","books.html");
        // ArrayList<NavDataItem> navDataItems1 = new ArrayList<>();
        // navDataItems1.add(navDataItem1);
        // NavData navData1 = new NavData("2","员工信息","icon iconfont icon-yuangongxinxi",navDataItems1);
        // data.add(navData1);
        //
        // NavDataItem navDataItem2 = new NavDataItem("3-1","用户管理","books.html");
        // ArrayList<NavDataItem> navDataItems2 = new ArrayList<>();
        // navDataItems2.add(navDataItem2);
        // NavData navData2 = new NavData("3","用户管理","icon iconfont icon-navicon-yhgl",navDataItems2);
        // data.add(navData2);
        //
        //
        // NavDataItem navDataItem3 = new NavDataItem("4-1","组织结构","books.html");
        // ArrayList<NavDataItem> navDataItems3 = new ArrayList<>();
        // navDataItems3.add(navDataItem3);
        // NavData navData3 = new NavData("4","组织结构","icon iconfont icon-zuzhiguanli",navDataItems3);
        // data.add(navData3);
        //
        //
        // NavDataItem navDataItem4 = new NavDataItem("5-1","薪酬结构","books.html");
        // ArrayList<NavDataItem> navDataItems4 = new ArrayList<>();
        // navDataItems4.add(navDataItem4);
        // NavData navData4 = new NavData("5","薪酬结构","icon iconfont icon-jiegou",navDataItems4);
        // data.add(navData4);
        //
        //
        // NavDataItem navDataItem5 = new NavDataItem("6-1","薪酬计算","books.html");
        // ArrayList<NavDataItem> navDataItems5 = new ArrayList<>();
        // navDataItems5.add(navDataItem5);
        // NavData navData5 = new NavData("6","薪酬计算","icon iconfont icon-navicon-yhgl",navDataItems5);
        // data.add(navData5);



        // Object data=null;
        Result result = new Result(Code.GET_OK,data);
        return result;
    }


}
