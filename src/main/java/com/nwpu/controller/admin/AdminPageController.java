package com.nwpu.controller.admin;

import com.nwpu.pojo.Admin;
import com.nwpu.pojo.Job;
import com.nwpu.service.admin.AdminWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/29
 * @ClassName AdminController
 * @Description:
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {
    @Autowired
    AdminWorkService adminWorkService;
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入登录页
     */
    @RequestMapping("/login")
    public String adminLogin(){
        return "adminPage/adminLogin";
    }
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入管理员工作页面
     */
    @RequestMapping("/jobinfo")
    public String adminJobInformation(Model model){
        List<Job> jobs = adminWorkService.getAllJobsFromDao();
        List<String> allKindsFromDao = adminWorkService.getAllKindsFromDao();
        List<String> allAreasFromDao = adminWorkService.getAllAreasFromDao();
        model.addAttribute("jobList",jobs);
        model.addAttribute("kindList",allKindsFromDao);
        model.addAttribute("areaList",allAreasFromDao);
        return "adminPage/adminJobInformation";
    }
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入管理员账号管理页面
     */
    @RequestMapping("/account")
    public String adminAccount(Model model){
        List<Admin> adminList = adminWorkService.getAllAdminsFromDao();
        model.addAttribute("adminList",adminList);
        return "adminPage/adminAccountManage";
    }

}
