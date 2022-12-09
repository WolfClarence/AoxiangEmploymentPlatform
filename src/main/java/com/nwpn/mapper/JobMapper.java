package com.nwpn.mapper;

import com.nwpn.pojo.Admin;
import com.nwpn.pojo.Job;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/29
 * @ClassName JobMapper
 * @Description:
 */
public interface JobMapper {
    List<Job> getJobs();
    Job getJobById(int id);//一般和修改函数相配合使用
    List<Job> getJobByLikedName(String name);//用于搜索,模糊搜索
    int insert(Job job);
    int delete(int id);
    int update(Job job);
}
