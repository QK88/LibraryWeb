package com.servlet.worker;

import com.dao.worOperater;
import com.entity.worker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "worregister",urlPatterns = "/worregister")
public class worregister extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("worid");
        String password= request.getParameter("workey");

        worker user = new worker(); //实例化一个对象，组装属性
        user.setId(id);
        worOperater ud = new worOperater();
        user.setWpwd(password);
        if(ud.register(user)){
            request.getSession().setAttribute("xiaoxi","注册成功");
            request.getRequestDispatcher("worlogin.jsp").forward(request, response);  //转发到登录页面
        }else{
            request.getSession().setAttribute("xiaoxi","注册失败");
            response.sendRedirect("worlogin.jsp");//重定向到首页
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
