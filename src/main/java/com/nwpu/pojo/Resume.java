package com.nwpu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/4
 * @ClassName Resume
 * @Description:
 *      简历的实体类，一个用户对应一个简历
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    private String owner_email;//主键，用户数据库查寻，同时也是外键
    private String name;//姓名
    private int sex;
    private String nation;//    民族
    private int age;
    private String profession;//专业
    private String intention ;//求职意向
    private String school;//毕业院校
    private String phone;
    private String email;
    private String skill;//技能
    private String award;//奖项
    private String practice;//社会实践
    private String description;//自我描述

}
