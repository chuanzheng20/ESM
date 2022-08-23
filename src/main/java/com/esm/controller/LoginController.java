package com.esm.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LoginController {


    // @RequestMapping("/login")
    // public Result Login(HttpServletResponse response, @RequestBody User user) throws IOException {
    //     User user1 = userService.getByUserName(user);
    //     Integer code = user1 != null ? Code.GET_OK : Code.GET_ERR;
    //     String msg = user1 != null ? "" : "用户名或密码错误，请重试！";
    //     // System.out.println(user);
    //
    //     String token = JWTUtil.createToken(user.getId(),user.getUserName(),"dshikcfkasosa",3600);
    //     response.addHeader("Set-Cookie", String.format("%s; %s",
    //             String.format("token=%s; Max-Age=%s; Path=/;%s HttpOnly", token, 3600, " Secure;"), "SameSite=None"));
    //     // response.setStatus(HttpStatus.OK.value());
    //     // response.sendRedirect("/pages/books.html");
    //     // response.sendRedirect("/pages/login.html");
    //     Result result = new Result(code, user1, msg);
    //     result.setUrl("/pages/books.html");
    //     return result;
    // }


}
