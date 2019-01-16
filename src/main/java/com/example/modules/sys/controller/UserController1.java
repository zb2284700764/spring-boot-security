package com.example.modules.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController1 {


    @RequestMapping("/user/userList")
    public ModelAndView userList(ModelAndView modelAndView) {

        modelAndView.setViewName("modules/sys/userList");
        return modelAndView;
    }

    @RequestMapping("/admin/userList")
    public ModelAndView adminList(ModelAndView modelAndView) {

        modelAndView.setViewName("modules/sys/userList");
        return modelAndView;
    }


    @RequestMapping("/user/toUser")
    public ModelAndView toUser(ModelAndView modelAndView) {

        modelAndView.setViewName("modules/sys/userDetail");
        return modelAndView;
    }

    @RequestMapping("/admin/toAdmin")
    public ModelAndView toAdmin(ModelAndView modelAndView) {

        modelAndView.setViewName("modules/sys/userDetail");
        return modelAndView;
    }
}
