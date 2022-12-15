package com.nwpu.controller.admin;

import com.mysql.cj.util.StringUtils;
import com.nwpu.pojo.*;
import com.nwpu.service.admin.AdminWorkService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName AdminWorkController
 * @Description:
 *      处理管理系统的负责业务逻辑（除登录相关逻辑外）
 */
@Controller
@RequestMapping("admin")
public class AdminWorkController {

    /**
     * <p> 变量描述如下:
     * @Description:
     *     service层调用
     */
    @Resource
    AdminWorkService adminWorkService;

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现管理员页面中对job的查询
     */
    @RequestMapping("query")
    public String query_impl(String kind, String area,
                             String keyword, Model model){
        System.out.println(keyword+kind+area);//测试,可以获得数据
        List<Job> res;
        res = adminWorkService.query(kind,area,keyword);
        List<String> allKindsFromDao = adminWorkService.getAllKindsFromDao();
        List<String> allAreasFromDao = adminWorkService.getAllAreasFromDao();
        model.addAttribute("jobList",res);
        model.addAttribute("kindList",allKindsFromDao);
        model.addAttribute("areaList",allAreasFromDao);
        return "adminPage/adminJobInformation";
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现对应聘者应聘状态的修改
     */
    @RequestMapping("/update/application/{id}/{jobId}/{email}")
    public void admin_update_application(String status,
                                         @PathVariable("id") String id,
                                         @PathVariable("jobId") String jobId,
                                         @PathVariable("email") String email,
                                         HttpServletRequest request,
                                         HttpServletResponse response) throws ServletException, IOException {
        int res = adminWorkService.updateApplicationStatusToDao(id,status);
        String msg;
        if(res<0){
            msg="抱歉小主，由于系统缘故修改失败";
        }else{
            msg = "修改成功！";
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/admin/jobdetail/employeedetail/"+jobId+"/"+email).forward(request,response);
    }


    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现对相应管理员账号的修改
     */
    @RequestMapping("/account/update")
    public void account_update_admin(String newPassword,String name,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws ServletException, IOException {
        System.out.println(newPassword+name);
        String msg;
        if(StringUtils.isNullOrEmpty(newPassword)){
            msg = "小主，新密码不能为空哟";
        }else{
            int res = adminWorkService.updateAccountToDao(name,newPassword);
            if(res <0){
                msg = "抱歉小主，由于系统或网络原因，修改失败";
            }else{
                msg = "恭喜小主，修改成功！";
            }
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/admin/account").forward(request,response);
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现对管理员账号的删除操作
     */
    @RequestMapping("/account/delete/{name}")
    public void account_delete_admin(@PathVariable("name")String name,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws ServletException, IOException {
        String msg;
        String nameInSession = ((Admin)(request.getSession().getAttribute("adminSession"))).getName();
        if(nameInSession.equals(name)){
            msg = "抱歉小主，你想删掉的是自己的账号，不能这么做哟。。";
        }else{
            int res = adminWorkService.deleteAccountByNameFromDao(name);
            if(res<0){
                msg = "抱歉小主，由于系统或者网络原因删除失败。。";
            }else{
                msg ="恭喜小主，删除成功！！";
            }
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/admin/account").forward(request,response);
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     管理员账号新增功能的实现
     */
    @RequestMapping("/account/add")
    public void account_add_admin(String name,String password,
                                  HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        String msg;
        if(StringUtils.isNullOrEmpty(name)||StringUtils.isNullOrEmpty(password)){
            msg = "抱歉小主，添加失败，名字和密码都是必填项哟,请重新添加";
        }else{
            if(adminWorkService.judgeIsContainNameInAdminDao(name)){
                msg = "抱歉小主，这个名称已经注册过了，请换个名字重新添加";
            }else{
                if(adminWorkService.addAccountToDao(name,password)>0){
                    msg = "恭喜小主，添加成功！！";
                }else{
                    msg = "不好意思小主，由于系统或者网络原因，添加失败。";
                }
            }
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/admin/account").forward(request,response);
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     职位添加功能的实现
     */
    @RequestMapping("job/add")
    public void job_add_admin(String name,String kind,
                              String company,String area,
                              int min_salary,int max_salary,
                              String description,String limit_condition,
                              HttpServletResponse response,
                              HttpServletRequest request) throws ServletException, IOException {
        String msg;
        if(StringUtils.isNullOrEmpty(name)){
            msg = "小主，职位名称不能为空哟,添加失败咯";
        }else{
            Job job = new Job(0,name,kind,company,area,min_salary,max_salary,description,limit_condition);
            if(adminWorkService.addJobToDao(job)>0){
                msg = "恭喜小主，添加成功！";
            }else{
                msg = "抱歉小主，由于系统或网络原因，添加失败";
            }
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/admin/jobinfo").forward(request,response);
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *      实现job的删除操作
     */
    @RequestMapping("job/delete/{jobId}")
    public void job_delete_admin(@PathVariable("jobId")int jobId,
                                 HttpServletResponse response,
                                 HttpServletRequest request) throws ServletException, IOException {
        String msg = "";
        boolean ok = true;
        try{
            adminWorkService.deleteJobByIdFromDao(jobId);
        }catch (DataIntegrityViolationException e){
            msg = "抱歉小主，已有用户申请该职位，暂时不能删除。";
            ok = false;
        }
        if (ok)
            msg = "删除成功";
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/admin/jobinfo").forward(request,response);
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     职位的更新功能的实现
     */
    @RequestMapping("job/update/{jobId}")
    public void job_delete_admin(@PathVariable("jobId")int jobId,
                                 String name,String kind,
                                 String company,String area,
                                 int min_salary,int max_salary,
                                 String description,String limit_condition,
                                 HttpServletResponse response,
                                 HttpServletRequest request) throws ServletException, IOException {
        Job job = new Job(jobId,name,kind,company,area,min_salary,max_salary,description,limit_condition);
        String msg;
        if(StringUtils.isNullOrEmpty(name)){
            msg = "职位名不能为空哟,修改失败";
        }else{
            int res = adminWorkService.updateJobToDao(job);
            if(res>0){
                msg = "恭喜小主，修改成功";
            }else {
                msg = "抱歉，由于系统原因或网络原因导致修改失败";
            }
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/admin/jobdetail/"+jobId).forward(request,response);
    }
}
