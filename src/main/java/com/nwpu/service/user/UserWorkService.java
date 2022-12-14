package com.nwpu.service.user;

import com.nwpu.mapper.ApplicationMapper;
import com.nwpu.mapper.JobMapper;
import com.nwpu.mapper.ResumeMapper;
import com.nwpu.pojo.Application;
import com.nwpu.pojo.Job;
import com.nwpu.pojo.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName UserWorkService
 * @Description:
 *      User相关业务逻辑的具体实现
 */
@Service
public class UserWorkService {
    @Autowired
    JobMapper jobMapper;
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    ResumeMapper resumeMapper;

    public List<Job> getAllJobsFromDao(){
        return jobMapper.getJobs();
    }
    public List<Application> getAllApplicationsFromDao(String owner_email){
        return applicationMapper.getApplicationByOwner_email(owner_email);
    }
    public Resume getResumeFromDao(String owner_email){
        return resumeMapper.getResumeByOwner_email(owner_email);
    }
    public int updateResumeInDao(Resume resume){
       return  resumeMapper.update(resume);
    }
}
