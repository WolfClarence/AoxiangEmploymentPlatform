package com.nwpn.controller.user;

import com.nwpn.pojo.Application;
import com.nwpn.pojo.Job;
import com.nwpn.pojo.Resume;
import com.nwpn.pojo.User;
import com.nwpn.service.user.UserWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author GengXuelong
 * @Email 3349495429@qq.com
 * @Date 2022-12-12
 * @version 1.0
 * @Description:
 *      实现user相关的页面的跳转
 */
@Controller
public class UserPageController {
    @Autowired
    UserWorkService userWorkService;

    /*
    页面跳转
     */
    @RequestMapping("/login")
    public String login(){
        return "userPage/userLogin";
    }
    @RequestMapping("/register")
    public String registry(){
        return "userPage/userRegister";
    }
    //招聘信息
    @RequestMapping("/job")
    public String job(Model model){
        /*
        每次进入此页面均应该获取后端数据库的最新数据
         */
        List<Job> allJobsFormDao = userWorkService.getAllJobsFromDao();
        model.addAttribute("jobList",allJobsFormDao);
        return "userPage/userJobInformation";
    }
    //我的申请
    @RequestMapping("/application")
    public String application(HttpServletRequest request, HttpServletResponse response,Model model){
         /*
        每次进入此页面均应该获取后端数据库的最新数据
         */
        String owner_email = getOwner_emailFromSession(request);
        List<Application> allApplicationsFromDao = userWorkService.getAllApplicationsFromDao(owner_email);
        model.addAttribute("applicationList",allApplicationsFromDao);
        return "userPage/userApplication";
    }
    //我的简历
    @RequestMapping("/resume")
    public String resume(HttpServletRequest request,HttpServletResponse response,Model model){
        Resume resume = userWorkService.getResumeFromDao(getOwner_emailFromSession(request));
        model.addAttribute("resume",resume);
        return "userPage/userResume";
    }
    //错误页面
    @RequestMapping("/error")
    public String error(){
        return "error";
    }

    private String  getOwner_emailFromSession(HttpServletRequest request){
        Object userSession = request.getSession().getAttribute("userSession");
        User user = (User)userSession;
        return user.getEmail();
    }
}
