package com.nwpu.controller.admin;

import com.nwpu.pojo.*;
import com.nwpu.service.admin.AdminWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/29
 * @ClassName AdminController
 * @Description:
 *      负责处理管理员系统的页面跳转的需要
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    /**
     * <p> 变量描述如下:
     * @Description:
     *     service层注入，用于该controller层的使用
     */
    @Resource
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

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入job详情页
     */
    @RequestMapping("/jobdetail/{jobId}")
    public String job_tail_admin(@PathVariable("jobId") String jobId, Model model){
        Job job =  adminWorkService.getJobByIdFromDao(jobId);
        List<String> areaList = adminWorkService.getAllAreasFromDao();
        List<String> kindList = adminWorkService.getAllKindsFromDao();
        model.addAttribute("job",job);
        model.addAttribute("areaList",areaList);
        model.addAttribute("kindList",kindList);
        return "adminPage/adminJobDetail";
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入job详情页中的申请得人员展示页
     */
    @RequestMapping("/jobdetail/employee/{jobId}")
    public String job_detail_employ_admin(@PathVariable("jobId") String jobId, Model model){

        List<User> users = adminWorkService.getUserListByJobIdFromDao(jobId);
        System.out.println("userList"+users);
        model.addAttribute("userList",users);
        model.addAttribute("jobId",jobId);
        return "adminPage/adminJobEmployee";
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入相应岗位的相应申请人员的详情页
     */
    @RequestMapping("/jobdetail/employeedetail/{jobId}/{email}")
    public String job_detail_employ_detail_admin(@PathVariable("jobId") String jobId,
                                                 @PathVariable("email") String email, Model model){
        Resume resume = adminWorkService.getResumeByEmailFromDao(email);
        System.out.println(resume);
        Application application = adminWorkService.getApplicationByJobIdAndEmailFromDao(jobId,email);
        System.out.println(application);
        model.addAttribute("resume",resume);
        model.addAttribute("application",application);
        return "adminPage/adminJobEmployeeDetail";
    }


}
