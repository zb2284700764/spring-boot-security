package com.example.modules.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {


    @RequestMapping("/user/userList")
    public ModelAndView userList(ModelAndView modelAndView) {

        modelAndView.setViewName("modules/sys/userList");
        return modelAndView;
    }

}
