package com.servlet.student;

import com.dao.stuOperater;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "stuBorrow",urlPatterns = "/stuBorrow")
public class stuBorrow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookid = request.getParameter("bookid"); //得到jsp页面传过来的参数
        String bookname = request.getParameter("bookname");
        String stuid = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {

            if("stuid".equals(cookie.getName())) {
                stuid=cookie.getValue();
            }
        }
        stuOperater ud = new stuOperater();

        if(ud.borrow(bookid,bookname,stuid)){
            request.getSession().setAttribute("xiaoxi", "借书成功"); //向request域中放置信息
            request.getRequestDispatcher("stuborrow.jsp").forward(request, response);//转发到成功页面
        }else{
            request.getSession().setAttribute("xiaoxi", "借书失败");
            response.sendRedirect("stuborrow.jsp"); //重定向到首页
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
}
