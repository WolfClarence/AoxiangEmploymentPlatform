package com.nwpu.service.admin;

import com.nwpu.mapper.AdminMapper;
import com.nwpu.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName AdminLoginService
 * @Description:
 */
@Service
public class AdminLoginService {
    @Autowired
    private AdminMapper adminMapper;

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     通过邮箱和密码来判断是否可以登录成功，如果登录成功则返回一个User对象，
     *     如果登录失败则返回null给controller，并让controller依据此来决定给前端页面的交互
     */
    public Admin login(String name, String password){
        Admin adminByName = adminMapper.getAdminByName(name);
        if(adminByName!=null&&adminByName.getPassword().equals(password)){
            return adminByName;
        }
        return null;
    }
}
