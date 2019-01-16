package com.example.modules.sys.controller;

import com.example.modules.sys.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * 后台登录 Controller
 */
@RestController
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



    @RequestMapping("/index")
    public ModelAndView defaultIndex(ModelAndView modelAndView, Model model) {

        // 为了在 layout.html 中获取用户名
        User user = new User();
        user.setUsername("张三");
        model.addAttribute("user", user);


        modelAndView.setViewName("modules/index");
        return modelAndView;
    }





}

