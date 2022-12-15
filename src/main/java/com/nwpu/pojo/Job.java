package com.nwpu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/29
 * @ClassName Job
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private int id;
    private String name; private String kind;

    private String company;
    private String area;
    private int min_salary;
    private int max_salary;
    private String description;
//    private User uploader;


    private String limit_condition;
}
