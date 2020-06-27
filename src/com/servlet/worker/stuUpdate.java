package com.servlet.worker;

import com.dao.worOperater;
import com.entity.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@WebServlet(name = "stuUpdate",urlPatterns = "/stuUpdate")
public class stuUpdate extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        student user=new student();
         user.setSid(request.getParameter("sid")); //得到jsp页面传过来的参数
        user.setSname(request.getParameter("sname"));
        user.setSex(request.getParameter("sex"));
        int credit=Integer.parseInt(request.getParameter("credit"));
        user.setCredit(credit);
        user.setPassword(request.getParameter("password"));
        worOperater ud = new worOperater();

        if(ud.updatestu(user)){
            request.getSession().setAttribute("xiaoxi", "更新成功"); //向request域中放置信息
            request.getRequestDispatcher("worstuupdate2.jsp").forward(request, response);//转发到成功页面
        }else{
            request.getSession().setAttribute("xiaoxi","更新失败");
            response.sendRedirect("worstuupdate2.jsp"); //重定向到首页
        }
    }
}
