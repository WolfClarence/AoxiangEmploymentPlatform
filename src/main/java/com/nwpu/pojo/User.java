package com.nwpu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName User
 * @Description:
 *      用户的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String email;//主键
    private String name;//用户名，不重要，用于页面显示
    private String password;
}
