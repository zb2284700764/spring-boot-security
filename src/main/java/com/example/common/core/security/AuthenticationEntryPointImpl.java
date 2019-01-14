package com.example.common.core.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 没有登录就请求资源时候的处理
 * 用来解决匿名用户访问无权限资源时的异常
 */
@Service("authenticationEntryPointImpl")
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        // 401 未授权
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,e.getMessage());

        // 没有登录就跳转到登录页
        response.sendRedirect(request.getContextPath()+"/login");
    }
}
