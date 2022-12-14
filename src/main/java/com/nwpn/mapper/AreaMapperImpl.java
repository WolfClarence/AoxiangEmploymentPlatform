package com.nwpn.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName AreaMapperImpl
 * @Description:
 */
@Repository
public class AreaMapperImpl implements AreaMapper{
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<String> getAreas() {
        return sqlSessionTemplate.getMapper(AreaMapper.class).getAreas();
    }

    @Override
    public int insert(String kind) {
        return sqlSessionTemplate.getMapper(AreaMapper.class).insert(kind);
    }

    @Override
    public int delete(String kind) {
        return sqlSessionTemplate.getMapper(AreaMapper.class).delete(kind);
    }

    @Override
    public int update(String oldArea, String newArea) {
        return sqlSessionTemplate.getMapper(AreaMapper.class).update(oldArea, newArea);
    }
}
