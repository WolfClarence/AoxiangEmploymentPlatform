package com.nwpn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/29
 * @ClassName AdminController
 * @Description:
 */
@Controller
public class AdminController {
    @RequestMapping("admin/jsp/main")
    public String adminMain(){
        return "adminPage/adminMain";
    }
    @RequestMapping("admin")
    public String adminLogin(){
        return "adminPage/adminLogin";
    }
    @PostMapping("admin/login.do")
    public String admin_login_do(HttpServletRequest request, HttpServletResponse response, Model model, String email, String password){
        System.out.println("admin:"+email+";;;"+password);
        boolean f = false;
        if(!f){
            model.addAttribute("msg","密码或用户名错误");
            return "adminPage/adminLogin";
        }
        request.getSession().setAttribute("adminSession","耿雪龙");
        return "adminPage/adminMain";
    }
}
