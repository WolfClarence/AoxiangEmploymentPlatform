package com.nwpu.service.user;

import com.nwpu.mapper.ApplicationMapper;
import com.nwpu.mapper.JobMapper;
import com.nwpu.mapper.ResumeMapper;
import com.nwpu.pojo.Application;
import com.nwpu.pojo.Job;
import com.nwpu.pojo.Resume;
import com.nwpu.service.admin.AdminWorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    /**
     * <p> 变量描述如下:
     * @Description:
     *     dao的自动注入，以便该service层的使用
     */
    @Resource
    JobMapper jobMapper;
    @Resource
    ApplicationMapper applicationMapper;
    @Resource
    ResumeMapper resumeMapper;

    /**
     * <p> 变量描述如下:
     * @Description:
     *     service同层之间的调用，以减少代码的重复编写，提高代码的复用率
     */
    @Resource
    AdminWorkService adminWorkService;

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

    public Job getJobByIdFromDao(int id) {
        return jobMapper.getJobById(id);
    }

    public int addApplicationToDao(Application application) {
        return applicationMapper.insert(application);
    }

    public List<Job> query(String kind, String area, String keyword) {
        return adminWorkService.query(kind,area,keyword);
    }

    public List<String> getAllKindsFromDao() {
        return adminWorkService.getAllKindsFromDao();
    }

    public List<String> getAllAreasFromDao() {
        return adminWorkService.getAllAreasFromDao();
    }
}
