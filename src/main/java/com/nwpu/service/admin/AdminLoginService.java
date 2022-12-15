package com.nwpu.service.admin;

import com.nwpu.mapper.AdminMapper;
import com.nwpu.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName AdminLoginService
 * @Description:
 *      管理系统的service层实现，负责处理登录业务相关的需要
 */
@Service
public class AdminLoginService {

    /**
     * <p> 变量描述如下:
     * @Description:
     *     dao层的注入
     */
    @Resource
    private AdminMapper adminMapper;

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     登录功能的实现，通过管理员名称和密码来判断是否可以登录成功，如果登录成功则返回一个Admin对象，
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
