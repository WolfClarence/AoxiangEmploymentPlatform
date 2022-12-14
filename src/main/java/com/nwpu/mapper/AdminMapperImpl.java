package com.nwpu.mapper;

import com.nwpu.pojo.Admin;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/4
 * @ClassName AdminMapperImpl
 * @Description:
 */
@Repository
public class AdminMapperImpl implements AdminMapper{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<Admin> getAdmins() {
        return sqlSessionTemplate.getMapper(AdminMapper.class).getAdmins();
    }

    @Override
    public Admin getAdminByName(String name) {
        return sqlSessionTemplate.getMapper(AdminMapper.class).getAdminByName(name);
    }

    @Override
    public int insert(Admin admin) {
        return sqlSessionTemplate.getMapper(AdminMapper.class).insert(admin);
    }

    @Override
    public int delete(String name) {
        return sqlSessionTemplate.getMapper(AdminMapper.class).delete(name);
    }

    @Override
    public int update(String name,String password) {
        return sqlSessionTemplate.getMapper(AdminMapper.class).update(name,password);
    }
}
