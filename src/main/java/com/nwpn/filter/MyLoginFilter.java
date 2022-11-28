package com.nwpn.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/11/28
 * @ClassName MyFilter
 * @Description:
 */
public class MyLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        Object userSession = httpServletRequest.getSession().getAttribute("userSession");
        if(userSession == null){
            httpServletResponse.sendRedirect("/error.jsp");
        }else{
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
