package com.nwpu.mapper;

import com.nwpu.pojo.Admin;
import com.nwpu.pojo.Resume;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/4
 * @ClassName ResumeMapperImpl
 * @Description:
 */
@Repository
public class ResumeMapperImpl implements ResumeMapper{
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public Resume getResumeByOwner_email(String email) {
        return sqlSessionTemplate.getMapper(ResumeMapper.class).getResumeByOwner_email(email);
    }

    @Override
    public int insert(Admin admin) {
        return sqlSessionTemplate.getMapper(ResumeMapper.class).insert(admin);
    }

    @Override
    public int delete(String email) {
        return sqlSessionTemplate.getMapper(ResumeMapper.class).delete(email);
    }

    @Override
    public int update(Resume resume) {
        return sqlSessionTemplate.getMapper(ResumeMapper.class).update(resume);
    }
}
