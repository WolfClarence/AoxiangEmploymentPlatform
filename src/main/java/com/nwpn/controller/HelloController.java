package com.nwpn.controller;

import com.nwpn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName HelloController
 * @Description:
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response, Model model){
        System.out.println("你好呀");
        model.addAttribute("msg","耿雪龙页面hello");
        return "hello";
    }

}
