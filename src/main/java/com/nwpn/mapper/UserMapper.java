package com.nwpn.mapper;

import com.nwpn.pojo.User;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName UserMapper
 * @Description:
 */
public interface UserMapper {
    List<User> getUsers();
    User getUserByEmail(String email);
}
