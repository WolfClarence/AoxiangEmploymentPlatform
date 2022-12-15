package com.nwpu.service.admin;

import com.mysql.cj.util.StringUtils;
import com.nwpu.mapper.*;
import com.nwpu.pojo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName AdminWorkService
 * @Description:
 *      管理系统的service层的实现
 */
@Service
public class AdminWorkService {

    /**
     * <p> 变量描述如下:
     * @Description:
     *     dao的引入
     */
    @Resource
    JobMapper jobMapper;
    @Resource
    ApplicationMapper applicationMapper;
    @Resource
    ResumeMapper resumeMapper;
    @Resource
    KindMapper kindMapper;
    @Resource
    AreaMapper areaMapper;
    @Resource
    AdminMapper adminMapper;



    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现admin的job页面的查询功能
     */
    public List<Job> query(String kind, String area, String keyword) {
        List<Job> res = jobMapper.getJobByLikedName(keyword);
        System.out.println(res);
        List<Job> removed = new ArrayList<>();
        if(!StringUtils.isNullOrEmpty(kind)){
            for (Job re : res) {
                if(!kind.equals(re.getKind())){
                    removed.add(re);
                }
            }
        }else{
            System.out.println("kind为null");
        }
        if(!StringUtils.isNullOrEmpty(area)){
            for (Job re : res) {
                if(!area.equals(re.getArea())){
                    removed.add(re);
                }
            }
        }else{
            System.out.println("area为null");
        }
        res.removeAll(removed);
        return res;
    }



    public List<Job> getAllJobsFromDao(){
        return jobMapper.getJobs();
    }

    public List<String> getAllKindsFromDao(){
        LinkedList<String> kinds = new LinkedList<>(kindMapper.getKinds());
        kinds.addFirst(null);
        return kinds;
    }

    public List<String> getAllAreasFromDao(){
        LinkedList<String> areas = new LinkedList<>(areaMapper.getAreas());
        areas.addFirst(null);
        return areas;
    }

    public List<Admin> getAllAdminsFromDao(){
        return new LinkedList<>(adminMapper.getAdmins());
    }

    public Job getJobByIdFromDao(String jobId) {
        return jobMapper.getJobById(Integer.parseInt(jobId));
    }

    public List<User> getUserListByJobIdFromDao(String jobId) {
        List<Application> applicationByJobId = applicationMapper.getApplicationByJobId(Integer.parseInt(jobId));
        System.out.println("applicationList"+applicationByJobId);
        List<User> userList = new LinkedList<>();
        for (Application application : applicationByJobId) {
            userList.add(application.getUser());
        }
        return userList;
    }

    public Resume getResumeByEmailFromDao(String email) {
        return resumeMapper.getResumeByOwner_email(email);
    }

    public Application getApplicationByJobIdAndEmailFromDao(String jobId, String email) {
        return applicationMapper.getApplicationByJobIdAndEmail(Integer.parseInt(jobId),email);
    }

    public int updateApplicationStatusToDao(String id, String status) {
        return applicationMapper.update(Integer.parseInt(id),status);
    }

    public int updateAccountToDao(String name, String newPassword) {
        return adminMapper.update(name,newPassword);
    }

    public boolean judgeIsContainNameInAdminDao(String name) {
        if (StringUtils.isNullOrEmpty(name))return false;
        List<Admin> adminList = adminMapper.getAdmins();
        for (Admin admin : adminList) {
            if (admin.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int addAccountToDao(String name, String password) {
        return adminMapper.insert(new Admin(name,password));
    }

    public int deleteAccountByNameFromDao(String name) {
        return adminMapper.delete(name);
    }

    public int addJobToDao(Job job) {
        return jobMapper.insert(job);
    }

    public int updateJobToDao(Job job) {
        return jobMapper.update(job);
    }

    public void deleteJobByIdFromDao(int jobId) {
        jobMapper.delete(jobId);
    }
}
