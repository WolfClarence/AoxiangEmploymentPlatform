package com.nwpn.controller.user;

import com.nwpn.pojo.Job;
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
}
