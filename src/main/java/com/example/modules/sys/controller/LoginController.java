package com.example.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * 后台登录 Controller
 */
@Controller
public class LoginController {


    /**
     * 跳转到登录页
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView toLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("modules/sys/login");
        return modelAndView;
    }
//    public String toLogin(ModelAndView modelAndView) {
//        return "modules/sys/login";
//    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(ModelAndView modelAndView, String username, String password) {

        modelAndView.setViewName("modules/sys/userList");
        return modelAndView;
    }


    @RequestMapping("/index")
    public ModelAndView defaultIndex(ModelAndView modelAndView) {
        modelAndView.setViewName("modules/index");
        return modelAndView;
    }

}

