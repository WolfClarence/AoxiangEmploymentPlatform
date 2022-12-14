package com.nwpn.controller.admin;

import com.nwpn.pojo.Job;
import com.nwpn.service.admin.AdminWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName AdminWorkController
 * @Description:
 */
@Controller
@RequestMapping("admin")
public class AdminWorkController {
    @Autowired
    AdminWorkService adminWorkService;
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现管理员页面中对job的查询
     */
    @RequestMapping("query")
    public String query_impl(String kind, String area, String keyword, Model model){
        System.out.println(keyword+kind+area);//测试,可以获得数据
        List<Job> res= null;
        res = adminWorkService.query(kind,area,keyword);
        List<String> allKindsFromDao = adminWorkService.getAllKindsFromDao();
        List<String> allAreasFromDao = adminWorkService.getAllAreasFromDao();
        model.addAttribute("jobList",res);
        model.addAttribute("kindList",allKindsFromDao);
        model.addAttribute("areaList",allAreasFromDao);
        return "adminPage/adminJobInformation";
    }

}
