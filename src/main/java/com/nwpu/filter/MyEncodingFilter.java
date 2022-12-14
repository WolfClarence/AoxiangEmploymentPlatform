package com.nwpu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName MyEncodingFilter
 * @Description:
 */
public class MyEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("进入encoding过滤器");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
//        System.out.println("出encoding过滤器");
    }

    @Override
    public void destroy() {

    }
}
