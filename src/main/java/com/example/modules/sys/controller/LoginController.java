package com.example.modules.sys.controller;

import com.example.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * 后台登录 Controller
 */
//@RestController
@RestController
public class LoginController {


    /**
     * 跳转到登录页
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView toLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("");
        return modelAndView;
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(ModelAndView modelAndView, String username, String password) {

        modelAndView.setViewName("modules/sys/login");
        return modelAndView;
    }

    /**
     * 退出登录之后会跳转到此方法
     *
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout() {

        return "redirect:/login";
    }

    @RequestMapping("/index")
    public ModelAndView defaultIndex(ModelAndView modelAndView) {
        modelAndView.setViewName("modules/index");
        return modelAndView;
    }

}

