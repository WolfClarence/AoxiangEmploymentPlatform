package com.nwpu.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class WelcomeTag extends TagSupport {
    public static int USER=0;
    public static int ADMIN=1;
    private int type;//添加的属性
    public void setType(int type) {
        this.type = type;
    }
    public int doStartTag(){
        if(type==0){
            JspWriter out=pageContext.getOut();
            String name= (String) pageContext.getSession().getAttribute("name");
            String html="欢迎管理员："+name;
            try {
                out.println(html);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(type==1){
            JspWriter out=pageContext.getOut();
            String name= (String) pageContext.getSession().getAttribute("name");
            String html="欢迎用户："+name;
            try {
                out.println(html);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SKIP_BODY;
    }

    public int doEndTag() {
        return EVAL_PAGE;
    }
}
