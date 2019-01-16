package com.example.modules.sys.controller;

import com.example.common.controller.BaseController;
import com.example.modules.sys.entity.User;
import com.example.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("${adminPath}/sys/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public String save(@ModelAttribute(value = "user") User user) {

        userService.save(user);

        LOGGER.info("UserController -> save -> 增加成功");
        return "redirect:" + adminPath + "/sys/user/findAllUser";
    }

    /**
     * 跳转到增加用户页面
     *
     * @date 2017年9月19日 下午2:20:59
     */
//    @RequiresPermissions("sys:user:edit")
    @RequestMapping("/gotoUserForm")
    public ModelAndView gotoUserForm(ModelAndView modelAndView) {

        // 对应 userForm.html 页面中 saveForm 下的表单对象
        modelAndView.addObject("user", new User());

        modelAndView.setViewName("modules/sys/userForm");
        LOGGER.info("UserController -> gotoUserForm -> 增加成功");
        return modelAndView;
    }

    /**
     * 查询所有用户
     *
     * @param modelAndView
     * @date 2017年9月18日 下午5:20:40
     */
    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView) {
        List<User> userList = userService.findAllUser();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("modules/sys/userList");
        return modelAndView;
    }

}
