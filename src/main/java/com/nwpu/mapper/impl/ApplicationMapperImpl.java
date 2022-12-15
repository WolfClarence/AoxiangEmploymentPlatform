package com.nwpu.mapper.impl;

import com.nwpu.mapper.ApplicationMapper;
import com.nwpu.pojo.Application;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/4
 * @ClassName ApplicationMapperImpl
 * @Description:
 */
@Repository
public class ApplicationMapperImpl implements ApplicationMapper {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<Application> getApplicationByOwner_email(String email) {
        return sqlSessionTemplate.getMapper(ApplicationMapper.class).getApplicationByOwner_email(email);
    }

    @Override
    public List<Application> getApplicationByJobId(int job_id) {
        return sqlSessionTemplate.getMapper(ApplicationMapper.class).getApplicationByJobId(job_id);
    }

    @Override
    public Application getApplicationByJobIdAndEmail(int job_id, String owner_email) {
        return sqlSessionTemplate.getMapper(ApplicationMapper.class).getApplicationByJobIdAndEmail(job_id,owner_email);
    }

    @Override
    public int insert(Application application) {
        return sqlSessionTemplate.getMapper(ApplicationMapper.class).insert(application);
    }

    @Override
    public int delete(int id) {
        return sqlSessionTemplate.getMapper(ApplicationMapper.class).delete(id);
    }

    @Override
    public int update(int id, String status) {
        return sqlSessionTemplate.getMapper(ApplicationMapper.class).update(id,status);
    }
}
