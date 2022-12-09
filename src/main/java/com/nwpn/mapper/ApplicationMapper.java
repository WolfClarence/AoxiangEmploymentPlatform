package com.nwpn.mapper;

import com.nwpn.pojo.Admin;
import com.nwpn.pojo.Application;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/4
 * @ClassName ApplicationMapper
 * @Description:
 */
public interface ApplicationMapper {
    List<Application> getApplicationByOwner_email(String email);
    int insert(Application application);
    int delete(int id);
    int update(int id,String status);//只能修改状态
}
