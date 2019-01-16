package com.example.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器父类
 */
public abstract class BaseController {

    public static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);


    /**
     * 管理基础路径
     */
    @Value("${adminPath}")
    protected String adminPath;


    /**
     * 判断是否是 ajax 请求
     * @param request 请求
     * @return 判断结果（true/false）
     */
    private static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("x-requested-with");
        return requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest");
    }

    @RequestMapping("/common/error/403")
    public ModelAndView error403(ModelAndView modelAndView){
        modelAndView.setViewName("common/error/403");
        return modelAndView;
    }

}
