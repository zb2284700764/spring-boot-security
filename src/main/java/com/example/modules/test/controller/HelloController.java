package com.example.modules.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/test")
@RestController
public class HelloController {


    /**
     * 测试输出 json 的方法
     * @return
     */
    @RequestMapping("/hiJson")
    public Map<String, Object> hiJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 14);
        map.put("score", 89.9);
        map.put("url", "www.baidu.com");
        map.put("key", "张三");
        return map;
    }



    @RequestMapping("/index")
    public ModelAndView userList(ModelAndView modelAndView) {

        modelAndView.setViewName("modules/test/index");
        return modelAndView;
    }


}
