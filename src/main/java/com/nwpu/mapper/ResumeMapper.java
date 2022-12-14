package com.nwpu.mapper;

import com.nwpu.pojo.Admin;
import com.nwpu.pojo.Resume;

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
    int update(Resume resume);
}
