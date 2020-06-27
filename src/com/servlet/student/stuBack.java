package com.servlet.student;

import com.dao.stuOperater;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "stuBack",urlPatterns = "/stuBack")
public class stuBack extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookid = request.getParameter("bid"); //得到jsp页面传过来的参数
        String stuid = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {

            if("stuid".equals(cookie.getName())) {
                stuid=cookie.getValue();
            }
        }
        stuOperater ud = new stuOperater();

        if(ud.back(stuid,bookid)){
            request.getSession().setAttribute("xiaoxi", "归还成功"); //向request域中放置信息
            request.getRequestDispatcher("stuback.jsp").forward(request, response);//转发到成功页面
        }else{
            request.getSession().setAttribute("xiaoxi","归还失败");
            response.sendRedirect("stuback.jsp"); //重定向到首页
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
}
