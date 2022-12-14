package com.nwpu.mapper;

import com.nwpu.pojo.Application;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/4
 * @ClassName ApplicationMapper
 * @Description:
 */
public interface ApplicationMapper {
    List<Application> getApplicationByOwner_email(String email);
    List<Application> getApplicationByJobId(int job_id);
    Application getApplicationByJobIdAndEmail(@Param("job_id") int job_id, @Param("owner_email") String owner_email);
    int insert(Application application);
    int delete(int id);
    int update(@Param("id") int id, @Param("status") String status);//只能修改状态
}
