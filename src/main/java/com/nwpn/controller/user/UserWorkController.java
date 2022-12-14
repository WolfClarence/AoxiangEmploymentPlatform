package com.nwpn.controller.user;

import com.nwpn.pojo.Job;
import com.nwpn.pojo.Resume;
import com.nwpn.service.user.UserWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
 * @ClassName UserWorkController
 * @Description:
 *      实现和user相关的众多具体业务(除登录相关逻辑)
 */
@Controller
public class UserWorkController {
    @Autowired
    UserWorkService userWorkService;

    @RequestMapping("/resume/fix.do")
    public void fix_do(HttpServletRequest request,HttpServletResponse response,String owner_email,
                       String name,String age,String sex,String nation ,String profession,
                       String intention,String school,String phone,String email,String skill,String award,
                       String practice,String description) throws ServletException, IOException {
        System.out.println(owner_email+name+age+sex+nation+profession+intention+school
                +phone+email+skill+award+practice+description);//测试数据传送,测试成功
        Resume resume = new Resume(owner_email,name,Integer.parseInt(sex),nation,Integer.parseInt(age)
        ,profession,intention,school,phone,email,skill,award,practice,description);
        int res = userWorkService.updateResumeInDao(resume);
        String msg = "";
        if(res<0){
            msg = "更新失败，请重试";
        }else{
            msg = "更新成功！";
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/resume/edit").forward(request,response);



    }
}
