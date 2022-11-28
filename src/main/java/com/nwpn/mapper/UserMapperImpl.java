package com.nwpn.mapper;

import com.nwpn.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
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
}
