package com.nwpn.mapper;

import com.nwpn.pojo.Job;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/29
 * @ClassName JobMapperImpl
 * @Description:
 */
@Repository
public class JobMapperImpl implements JobMapper{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<Job> getJobs() {
        return sqlSessionTemplate.getMapper(JobMapper.class).getJobs();
    }
}
