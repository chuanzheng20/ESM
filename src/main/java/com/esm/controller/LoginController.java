package com.esm.controller;

import com.esm.domain.NavData;
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

        Result result = new Result(Code.GET_OK,data);
        return result;
    }


}
