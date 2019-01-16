package com.example.modules.sys.controller;

import com.example.common.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${adminPath}/sys/menu")
public class MenuController extends BaseController {


    @RequestMapping("/list")
    public String list(String userId) {

        return null;
    }
}
