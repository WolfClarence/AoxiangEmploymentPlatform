package com.nwpn.controller.admin;

import com.nwpn.pojo.Job;
import com.nwpn.pojo.User;
import com.nwpn.service.admin.AdminWorkService;
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
public class AdminPageController {
    @Autowired
    AdminWorkService adminWorkService;
    @RequestMapping("admin")
    public String adminLogin(){
        return "adminPage/adminLogin";
    }
    @RequestMapping("admin/jobinfo")
    public String adminJobInformation(Model model){
        List<Job> jobs = adminWorkService.getAllJobsFromDao();
        model.addAttribute("jobList",jobs);
        return "adminPage/adminJobInformation";
    }
    @RequestMapping("admin/employee")
    public String adminEmployee(Model model){
        List<User> allUsersFromDao = adminWorkService.getAllUsersFromDao();
        model.addAttribute("userList",allUsersFromDao);
        return "adminPage/adminEmployee";
    }
    @RequestMapping("admin/account")
    public String adminAccount(){

        return "adminPage/adminAccountManage";
    }
}
