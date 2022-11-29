package com.nwpn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName MainController
 * @Description:
 */
@Controller
public class MainController {
    @RequestMapping("/jsp/main")
    public String main(){
        return "jobShow/main";
    }
}
