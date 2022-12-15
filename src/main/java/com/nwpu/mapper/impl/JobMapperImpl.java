package com.nwpu.mapper.impl;

import com.nwpu.mapper.JobMapper;
import com.nwpu.pojo.Job;
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
public class JobMapperImpl implements JobMapper {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<Job> getJobs() {
        return sqlSessionTemplate.getMapper(JobMapper.class).getJobs();
    }

    @Override
    public Job getJobById(int id) {
        return sqlSessionTemplate.getMapper(JobMapper.class).getJobById(id);

    }

    @Override
    public Job getJobByKind(String kind) {
        return sqlSessionTemplate.getMapper(JobMapper.class).getJobByKind(kind);

    }

    @Override
    public List<Job> getJobByLikedName(String name) {
        return sqlSessionTemplate.getMapper(JobMapper.class).getJobByLikedName(name);
    }

    @Override
    public int insert(Job job) {
        return sqlSessionTemplate.getMapper(JobMapper.class).insert(job);
    }

    @Override
    public int delete(int id) {
        return sqlSessionTemplate.getMapper(JobMapper.class).delete(id);
    }

    @Override
    public int update(Job job) {
        return sqlSessionTemplate.getMapper(JobMapper.class).update(job);
    }
}
