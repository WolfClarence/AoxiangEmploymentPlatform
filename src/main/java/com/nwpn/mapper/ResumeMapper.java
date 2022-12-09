package com.nwpn.mapper;

import com.nwpn.pojo.Admin;
import com.nwpn.pojo.Resume;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/4
 * @ClassName ResumeMapper
 * @Description:
 */
public interface ResumeMapper {
    Resume getResumeByOwner_email(String email);
    int insert(Admin admin);
    int delete(String email);//简历的主键为用户的注册邮箱
    int update(String name,String password);
}
