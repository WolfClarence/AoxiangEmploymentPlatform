package com.nwpn.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName AreaMapper
 * @Description:
 */

public interface AreaMapper {
    List<String> getAreas();
    int insert(String kind);
    int delete(String kind);
    int update(String oldArea,String newArea);
}
