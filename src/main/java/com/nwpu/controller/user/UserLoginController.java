package com.nwpu.controller.user;

import com.mysql.cj.util.StringUtils;
import com.nwpu.pojo.Resume;
import com.nwpu.pojo.User;
import com.nwpu.service.user.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName UserLoginController
 * @Description:
 *      实现用户的登录登出等相关功能
 */
@Controller
public class UserLoginController {

   /**
    * <p> 变量描述如下:
    * @Description:
    *     service层引入
    */
    @Resource
    UserLoginService userLoginService;

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现用户登录功能
     */
    @RequestMapping("/login.do")
    public void login_do(HttpServletRequest request,
                         HttpServletResponse response,
                         String email, String password) throws ServletException, IOException {

        /*
        实现登录的业务
         */
        User login = userLoginService.login(email, password);

        /*
        实现登录的业务
         */
        if(login==null){
            request.setAttribute("loginFail","用户名或密码错误");// 方便自定义Tag获取该值
            request.getRequestDispatcher("/login").forward(request,response);
        }

        /*
        登录成功
        之后的操作为，
        1.将用户名放入cookie中传至前端页面，供其在适当时机使用。
        2. 将承载用户信息的User对象放入session中，为拦截器拦截未登录的用户提供条件
        3. 跳转到岗位展示页面
         */
        assert login != null;
        String username = login.getName();
        Cookie userNameCookie = new Cookie("username", URLEncoder.encode(username,"utf-8"));
        response.addCookie(userNameCookie);
        request.getSession().setAttribute("userSession",login);
        request.getRequestDispatcher("/job").forward(request,response);
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现注册功能
     */
    @RequestMapping("/register.do")
    public void register_do(HttpServletRequest request,
                            HttpServletResponse response,
                            String email,
                            String name,
                            String password) throws ServletException, IOException {

        String msg ;
        if(StringUtils.isNullOrEmpty(email)||StringUtils.isNullOrEmpty(name)||StringUtils.isNullOrEmpty(password)){
            msg= "填入数据均不能为空哟小主";
        }else{
            User user = userLoginService.getUserByEmailFromDao(email);
            //如果邮箱已经注册
            if(user!=null){
                msg = "小主，您的邮箱已经注册过了，请直接登录，不需要再注册啦！";
            }else{
                User user1 = new User(email,name,password);
                int res = userLoginService.addUserToDao(user1);
                //如果因为系统原因注册失败
                if(res < 0){
                    msg = "小主，因为系统或者网络原因注册不小心失败了，请小主重新注册..";
                    //注册成功
                }else{
                    msg = "恭喜小主，注册成功,赶快去登录吧！";
                    Resume resume = new Resume();
                    resume.setOwner_email(email);
                    userLoginService.addResumeToDao(resume);
                }
            }
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/register").forward(request,response);
    }
}
