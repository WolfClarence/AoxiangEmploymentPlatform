package com.nwpn.utils;

import com.nwpn.mapper.JobMapper;
import com.nwpn.mapper.UserMapper;
import com.nwpn.pojo.User;
import com.nwpn.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName test
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
        JobMapper bean = context.getBean(JobMapper.class);
        System.out.println(bean.getJobs());
    }
}
