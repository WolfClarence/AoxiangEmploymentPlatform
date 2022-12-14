package com.nwpu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/4
 * @ClassName Application
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    private int id;
    private User user;//owner_id
    private Job job;//jobId
    private String status;//正在处理，应聘成功，已驳回，等
}
