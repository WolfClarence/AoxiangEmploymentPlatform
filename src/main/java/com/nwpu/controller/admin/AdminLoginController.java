package com.nwpu.controller.admin;

import com.nwpu.pojo.Admin;
import com.nwpu.service.admin.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName AdminLoginController
 * @Description:
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {
    @Autowired
    AdminLoginService adminLoginService;
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现登录功能
     */
    @RequestMapping("/login.do")
    public String login_do(HttpServletRequest request, HttpServletResponse response, String name, String password, Model model) throws ServletException, IOException {
        System.out.println(name+"::::::"+password);//测试
        Admin login = adminLoginService.login(name, password);//实现登录的业务
        if(login==null){//登录失败后
            model.addAttribute("msg","用户名或密码错误");
            return "adminPage/adminLogin";
        }
        /*
        登录成功后的操作，
        1. 将承载用户信息的User对象放入session中，为拦截器拦截未登录的用户提供条件
        2. 跳转到岗位展示页面
         */
        request.getSession().setAttribute("adminSession",login);
        request.getRequestDispatcher("/admin/jobinfo").forward(request,response);
        return null;
    }
}
