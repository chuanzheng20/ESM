package com.esm.controller.interceptor;

import com.esm.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目web拦截器
 */
@Component
public class ProjectInterceptor implements HandlerInterceptor {
    @Value("${key}")
    private String key;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // System.out.println("preHandle....");
        String requestURL=request.getRequestURI();
        System.out.println("preHandle Interceptor路径："+requestURL);
        if (requestURL.equals("/login")){
            return true;
        }
        //自动登录检查业务逻辑
        //获取cookie中的token，检查是否签发的token
        Cookie[] cookies=request.getCookies();
        if(cookies!=null&&cookies.length!=0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();

                    Claims claims = JWTUtil.parseToken(token, key);
                    // System.out.println(claims.get("userId"));
                    if (claims!=null)
                        return true;

                }
            }
        }


        //拦截，跳转登录页
        request.setAttribute("msg","请先登录");
        response.setStatus(HttpStatus.OK.value());
        response.sendRedirect("/pages/login.html");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // System.out.println("postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // System.out.println("afterCompletion...");
    }
}
