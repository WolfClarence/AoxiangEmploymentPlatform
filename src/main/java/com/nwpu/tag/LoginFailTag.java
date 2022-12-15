package com.nwpu.tag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * @author SongYuxuan
 * @Date 2022-12-13
 * @version 1.0
 * @Description:
 *      自定义Tag标签，用于展示错误提示信息
 */
public class LoginFailTag extends TagSupport {
    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        String fail = (String) pageContext.getRequest().getAttribute("loginFail");
        try {
            if(fail!=null){
                out.println(fail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    public int doEndTag() {
        return EVAL_PAGE;
    }
}
