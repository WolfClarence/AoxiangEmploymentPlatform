package com.nwpu.mapper.impl;

import com.nwpu.mapper.KindMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName KindMapperImpl
 * @Description:
 */
@Repository
public class KindMapperImpl implements KindMapper {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<String> getKinds() {
        return sqlSessionTemplate.getMapper(KindMapper.class).getKinds();
    }

    @Override
    public int insert(String kind) {
        return sqlSessionTemplate.getMapper(KindMapper.class).insert(kind);
    }

    @Override
    public int delete(String kind) {
        return sqlSessionTemplate.getMapper(KindMapper.class).delete(kind);
    }

    @Override
    public int update(String oldKind, String newKind) {
        return sqlSessionTemplate.getMapper(KindMapper.class).update(oldKind,newKind);
    }
}
