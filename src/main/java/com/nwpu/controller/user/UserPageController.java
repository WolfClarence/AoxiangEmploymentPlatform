package com.nwpu.controller.user;

import com.nwpu.pojo.Application;
import com.nwpu.pojo.Job;
import com.nwpu.pojo.Resume;
import com.nwpu.pojo.User;
import com.nwpu.service.user.UserWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
    /**
     * <p> 变量描述如下:
     * @Description:
     *     service引入
     */
    @Resource
    UserWorkService userWorkService;

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入用户登录页
     */
    @RequestMapping("/login")
    public String login(){
        return "userPage/userLogin";
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入注册页面
     */
    @RequestMapping("/register")
    public String registry(){
        return "userPage/userRegister";
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入招聘信息展示页面，也就是用户主页面
     */
    @RequestMapping("/job")
    public String job(Model model){
        /*
        每次进入此页面均应该获取后端数据库的最新数据
         */
        List<Job> allJobsFormDao = userWorkService.getAllJobsFromDao();
        List<String> allKindsFromDao = userWorkService.getAllKindsFromDao();
        List<String> allAreasFromDao = userWorkService.getAllAreasFromDao();
        model.addAttribute("kindList",allKindsFromDao);
        model.addAttribute("areaList",allAreasFromDao);
        model.addAttribute("jobList",allJobsFormDao);
        return "userPage/userJobInformation";
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入”我的申请“页面
     */
    @RequestMapping("/application")
    public String application(HttpServletRequest request,
                              Model model){
         /*
        每次进入此页面均应该获取后端数据库的最新数据
         */
        String owner_email = getOwner_emailFromSession(request);
        List<Application> allApplicationsFromDao = userWorkService.getAllApplicationsFromDao(owner_email);
        model.addAttribute("applicationList",allApplicationsFromDao);
        return "userPage/userApplication";
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入”我的简历“页面
     */
    @RequestMapping("/resume")
    public String resume(HttpServletRequest request,
                         Model model){
        Resume resume = userWorkService.getResumeFromDao(getOwner_emailFromSession(request));
        model.addAttribute("resume",resume);
        return "userPage/userResume";
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入修改简历的页面
     */
    @RequestMapping("/resume/edit")
    public String resumeEdit(HttpServletRequest request,
                             Model model){
         /*
        每次进入此页面均应该获取后端数据库的最新数据
         */
        Resume resume = userWorkService.getResumeFromDao(getOwner_emailFromSession(request));
        model.addAttribute("resume",resume);
        return "userPage/userResumeEdit";
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     进入职位详情展示页
     */
    @RequestMapping("/jobdetail/{id}")
    public String user_to_jobDetail(@PathVariable("id")int id, Model model){
        Job job = userWorkService.getJobByIdFromDao(id);
        model.addAttribute("job",job);
        return "userPage/userJobDetail";
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     私用工具方法
     */
    private String  getOwner_emailFromSession(HttpServletRequest request){
        Object userSession = request.getSession().getAttribute("userSession");
        User user = (User)userSession;
        return user.getEmail();
    }
}
