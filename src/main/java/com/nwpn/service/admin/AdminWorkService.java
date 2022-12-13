package com.nwpn.service.admin;

import com.nwpn.mapper.ApplicationMapper;
import com.nwpn.mapper.JobMapper;
import com.nwpn.mapper.ResumeMapper;
import com.nwpn.mapper.UserMapper;
import com.nwpn.pojo.Job;
import com.nwpn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName AdminWorkService
 * @Description:
 */
@Service
public class AdminWorkService {
    @Autowired
    JobMapper jobMapper;
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    ResumeMapper resumeMapper;
    @Autowired
    UserMapper userMapper;

    public List<Job> getAllJobsFromDao(){
        return jobMapper.getJobs();
    }
    public List<User> getAllUsersFromDao(){
        return userMapper.getUsers();
    }
}
