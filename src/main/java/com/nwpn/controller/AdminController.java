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
    @RequestMapping("admin")
    public String adminLogin(){
        return "adminPage/adminLogin";
    }
    @RequestMapping("admin/jobinfo")
    public String adminJobInformation(){
        return "adminPage/adminJobInformation";
    }
    @RequestMapping("admin/employee")
    public String adminEmployee(){
        return "adminPage/adminEmployee";
    }
    @RequestMapping("admin/account")
    public String adminAccount(){
        return "adminPage/adminAccountManage";
    }
    @PostMapping("admin/login.do")
    public String admin_login_do(HttpServletRequest request, HttpServletResponse response, Model model, String email, String password){
        System.out.println("admin:"+email+";;;"+password);
        boolean f = true;
        if(!f){
            model.addAttribute("msg","密码或用户名错误");
            return "adminPage/adminLogin";
        }
        request.getSession().setAttribute("adminSession","耿雪龙");
        return "adminPage/adminJobInformation";
    }
}
