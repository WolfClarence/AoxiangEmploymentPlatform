package com.nwpu.controller.admin;

import com.nwpu.pojo.Admin;
import com.nwpu.service.admin.AdminLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName AdminLoginController
 * @Description:
 *      管理管理员系统的登录相关的操作
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {
    /**
     * <p> 变量描述如下:
     * @Description:
     *     service层的调用
     */
    @Resource
    AdminLoginService adminLoginService;


    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现登录功能
     */
    @RequestMapping("/login.do")
    public void login_do(HttpServletRequest request, HttpServletResponse response, String name, String password) throws ServletException, IOException {

        /*
        实现登录的业务
         */
        Admin login = adminLoginService.login(name, password);

        /*
        登录失败后
         */
        if(login==null){
            request.setAttribute("loginFail","用户名或密码错误");
            request.getRequestDispatcher("/admin/login").forward(request,response);
        }

        /*
        登录成功
        之后的操作是：
        1.将用户名放入cookie中传至前端页面，供其在适当时机使用。
        2. 将承载管理员信息的Admin对象放入session中，为拦截器拦截未登录的用户提供条件
        3. 跳转到岗位展示页面
         */
        assert login != null;
        String adminName = login.getName();
        Cookie adminNameCookie = new Cookie("adminName", URLEncoder.encode(adminName,"utf-8"));
        response.addCookie(adminNameCookie);
        request.getSession().setAttribute("adminSession",login);
        request.getRequestDispatcher("/admin/jobinfo").forward(request,response);
    }
}
