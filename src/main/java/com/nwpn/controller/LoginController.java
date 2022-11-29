package com.nwpn.controller;

import com.nwpn.pojo.User;
import com.nwpn.service.LoginService;
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
 * @Date 2022/11/28
 * @ClassName LoginController
 * @Description:
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/error")
    public String error(){
        return "error";
    }


    @RequestMapping("/login.do")
    public String login2(HttpServletRequest request, HttpServletResponse response, String email, String password, Model model) throws ServletException, IOException {
        System.out.println(email+"::"+password);
//        User login = loginService.login(email, password);
        User login = new User();
        if(login==null){
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
        request.getSession().setAttribute("userSession",login);
        request.getRequestDispatcher("/main.do").forward(request,response);
        return null;
    }
}
