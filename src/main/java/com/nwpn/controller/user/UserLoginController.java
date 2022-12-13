package com.nwpn.controller.user;

import com.nwpn.pojo.User;
import com.nwpn.service.user.UserLoginService;
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
 * @ClassName UserLoginController
 * @Description:
 *      实现用户的登录登出等相关功能
 */
@Controller
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现登录功能
     */
    @RequestMapping("/login.do")
    public String login_do(HttpServletRequest request, HttpServletResponse response, String email, String password, Model model) throws ServletException, IOException {
        System.out.println(email+"::::::"+password);//测试
        User login = userLoginService.login(email, password);//实现登录的业务
        if(login==null){//登录失败后
            model.addAttribute("msg","用户名或密码错误");
            return "userPage/userLogin";
        }
        /*
        登录成功后的操作，
        1. 将承载用户信息的User对象放入session中，为拦截器拦截未登录的用户提供条件
        2. 跳转到岗位展示页面
         */
        request.getSession().setAttribute("userSession",login);
        request.getRequestDispatcher("/job").forward(request,response);
        return null;
    }
}
