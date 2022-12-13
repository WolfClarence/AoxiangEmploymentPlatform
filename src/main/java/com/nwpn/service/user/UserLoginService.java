package com.nwpn.service.user;

import com.nwpn.mapper.UserMapper;
import com.nwpn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName UserLoginService
 * @Description:
 *      实现用户登录登出等业务的具体实现
 */
@Service
public class UserLoginService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     通过邮箱和密码来判断是否可以登录成功，如果登录成功则返回一个User对象，
     *     如果登录失败则返回null给controller，并让controller依据此来决定给前端页面的交互
     */
    public User login(String email,String password){
        User userByEmail = userMapper.getUserByEmail(email);
        if(userByEmail!=null&&userByEmail.getPassword().equals(password)){
            return userByEmail;
        }
        return null;

    }
}
