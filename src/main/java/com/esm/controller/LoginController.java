package com.esm.controller;

import com.esm.domain.User;
import com.esm.service.LoginService;
import com.esm.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;

    @Value("${key}")
    private String  key;

    @PostMapping("/login")
    public Result Login(HttpServletResponse response, @RequestBody User user) throws IOException {

        User loginUser = loginService.Login(user);
        Integer code = loginUser != null ? Code.GET_OK : Code.GET_ERR;
        String msg = loginUser != null ? "" : "用户名或密码错误，请重试！";
        if (loginUser!=null){
            String token = JWTUtil.createToken(user.getUserId(),user.getName() ,key,3600);
            response.addHeader("Set-Cookie", String.format("%s; %s",
                    String.format("token=%s; Max-Age=%s; Path=/;%s HttpOnly", token, 3600, " Secure;"), "SameSite=None"));
        }
        Result result = new Result(code, loginUser, msg);
        result.setUrl("/pages/books.html");
        return result;
    }

    @PostMapping("/logout")
    public Result out(HttpServletResponse response) throws IOException {

        Result result = new Result(Code.GET_OK , null, "");

        result.setUrl("/pages/login.html");

        response.setHeader("Set-Cookie", String.format("%s; %s",
                String.format("token=; Max-Age=%s; Path=/;%s HttpOnly", 3600, " Secure;"), "SameSite=None"));
        return result;
    }


}
