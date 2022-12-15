package com.nwpu.mapper;

import com.nwpu.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/4
 * @ClassName AdminMapper
 * @Description:
 */
public interface AdminMapper {
    List<Admin> getAdmins();
    Admin getAdminByName(String name);
    int insert(Admin admin);
    int delete(String name);
    int update(@Param("name") String name, @Param("password") String password);//只能修改密码，管理员的名字为主键
}
