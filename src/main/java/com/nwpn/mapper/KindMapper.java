package com.nwpn.mapper;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/13
 * @ClassName KindMapper
 * @Description:
 */
public interface KindMapper {
    List<String> getKinds();
    int insert(String kind);
    int delete(String kind);
    int update(String oldKind,String newKind);
}
