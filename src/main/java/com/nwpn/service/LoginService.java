package com.nwpn.service;

import com.nwpn.mapper.UserMapper;
import com.nwpn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName LoginService
 * @Description:
 */
@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    public User login(String email,String password){
        User userByEmail = userMapper.getUserByEmail(email);
        if(userByEmail!=null&&userByEmail.getPassword().equals(password)){
            return userByEmail;
        }
        return null;

    }
}
