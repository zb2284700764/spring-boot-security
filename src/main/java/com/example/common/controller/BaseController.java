package com.example.common.controller;

import com.example.modules.sys.entity.Menu;
import com.example.modules.sys.entity.User;
import com.example.modules.sys.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 控制器父类
 */
public abstract class BaseController {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected MenuService menuService;

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



    /**
     * 查询菜单, 每次请求都会查询一次
     * @param modelAndView 在当前 controller 里面只存放菜单数据
     * @return 菜单数据
     */
    @ModelAttribute
    public ModelAndView initMenu(ModelAndView modelAndView) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null) {
            modelAndView.addObject("user", user);
            List<Menu> menuList = menuService.findMenuByUserId(user.getId());
            if (menuList != null) {
                modelAndView.addObject("menuList",menuList);
            }
        }
        return modelAndView;
    }
}
