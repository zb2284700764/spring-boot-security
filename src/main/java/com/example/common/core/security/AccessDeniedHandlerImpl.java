package com.example.common.core.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用来解决认证过的用户访问无权限资源时的异常
 * 暂时还没用
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    private Logger logger = LoggerFactory.getLogger(AccessDeniedHandler.class);


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (null != authentication) {
            logger.info("User '" + authentication.getName() + "' attempted to access the protected URL: " + request.getRequestURI());
        }

        // 访问异常的时候转到首页
        response.sendRedirect(request.getContextPath()+"/index");

    }


}
