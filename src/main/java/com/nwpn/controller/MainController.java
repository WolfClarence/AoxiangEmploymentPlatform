package com.nwpn.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName MainController
 * @Description:
 */
public class MainController {
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
