package com.nwpn.controller;

import com.nwpn.pojo.Job;
import com.nwpn.service.JobService;
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
 * @Date 2022/11/29
 * @ClassName JobController
 * @Description:
 */
@Controller
public class JobController {
    @Autowired
    private JobService jobService;
    @RequestMapping("/main.do")
    public void main_do(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Job> jobs = jobService.getJobs();
        request.setAttribute("jobs",jobs);
        request.getRequestDispatcher("/jsp/main").forward(request,response);
    }
}
