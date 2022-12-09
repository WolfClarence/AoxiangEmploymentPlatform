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

@Controller
public class UserController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(){
        return "userPage/userLogin";
    }
    @RequestMapping("/register")
    public String registry(){
        return "userPage/userRegister";
    }
    @RequestMapping("/job")
    public String job(){
        return "userPage/userJobInformation";
    }
    @RequestMapping("/application")
    public String application(){
        return "userPage/userApplication";
    }
    @RequestMapping("/resume")
    public String resume(){
        return "userPage/userResume";
    }
    @RequestMapping("/error")
    public String error(){
        return "error";
    }


    @RequestMapping("/login.do")
    public String login2(HttpServletRequest request, HttpServletResponse response, String email, String password, Model model) throws ServletException, IOException {
        System.out.println(email+"::"+password);
        User login = loginService.login(email, password);
        if(login==null){
            model.addAttribute("msg","用户名或密码错误");
            return "userPage/userLogin";
        }
        request.getSession().setAttribute("userSession",login);
        request.getRequestDispatcher("/job").forward(request,response);
        return null;
    }
}
