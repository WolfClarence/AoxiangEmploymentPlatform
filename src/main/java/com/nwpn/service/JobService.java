package com.nwpn.service;

import com.nwpn.mapper.JobMapper;
import com.nwpn.pojo.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/29
 * @ClassName JobService
 * @Description:
 */
@Service
public class JobService {
    @Autowired
    private JobMapper jobMapper;

    public List<Job> getJobs(){
        return jobMapper.getJobs();
    }
}
