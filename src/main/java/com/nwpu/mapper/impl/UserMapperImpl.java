package com.nwpu.mapper.impl;

import com.nwpu.mapper.UserMapper;
import com.nwpu.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName UserMapperImpl
 * @Description:
 */
@Repository
public class UserMapperImpl  implements UserMapper {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<User> getUsers() {
        return sqlSessionTemplate.getMapper(UserMapper.class).getUsers();
    }

    @Override
    public User getUserByEmail(String email) {
        return sqlSessionTemplate.getMapper(UserMapper.class).getUserByEmail(email);
    }

    @Override
    public int insert(User user) {
        return sqlSessionTemplate.getMapper(UserMapper.class).insert(user);
    }

    @Override
    public int delete(String email) {
        return sqlSessionTemplate.getMapper(UserMapper.class).delete(email);
    }

    @Override
    public int update(User user) {
        return sqlSessionTemplate.getMapper(UserMapper.class).update(user);
    }
}
