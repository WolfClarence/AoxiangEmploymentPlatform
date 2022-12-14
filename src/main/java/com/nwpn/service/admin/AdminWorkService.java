package com.nwpn.service.admin;

import com.mysql.cj.util.StringUtils;
import com.nwpn.mapper.*;
import com.nwpn.pojo.Job;
import com.nwpn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    KindMapper kindMapper;
    @Autowired
    AreaMapper areaMapper;

    public List<Job> getAllJobsFromDao(){
        return jobMapper.getJobs();
    }
//    public List<User> getAllUsersFromDao(){
//        return userMapper.getUsers();
//    }
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

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     实现admin - job页面的查询功能
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
}
